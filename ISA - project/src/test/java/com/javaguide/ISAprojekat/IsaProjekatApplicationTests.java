package com.javaguide.ISAprojekat;

import com.javaguide.ISAprojekat.dto.AppointmentDTO;
import com.javaguide.ISAprojekat.model.Appointment;
import com.javaguide.ISAprojekat.service.AppointmentService;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.orm.ObjectOptimisticLockingFailureException;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

//@RunWith(SpringRunner.class)
@ExtendWith(SpringExtension.class)
@SpringBootTest
public class IsaProjekatApplicationTests {

	@Autowired
	private AppointmentService appointmentService;

	@Test
	public void testOptimisticLockingSchedulingAppointment() throws Throwable {
		assertThrows(ObjectOptimisticLockingFailureException.class, () -> {
		ExecutorService executor = Executors.newFixedThreadPool(2);
		LocalDateTime localDateTime1 = LocalDateTime.of(
				2023, 01, 24, 14, 33, 48, 123456789);
		LocalDateTime localDateTime2 = LocalDateTime.of(
				2023, 01, 22, 14, 33, 48, 123456789);
		appointmentService.saveAppointment(new AppointmentDTO(localDateTime1, localDateTime1.plusHours(1), 1L));
		appointmentService.saveAppointment(new AppointmentDTO(localDateTime2, localDateTime2.plusHours(1), 1L));
		Future<?> future1 = executor.submit(new Runnable() {

			@Override
			public void run() {
				System.out.println("Startovan Thread 1");
				Appointment appointmentSchedule = appointmentService.findById(1L);// ocitan objekat sa id 1
				try { Thread.sleep(3000); } catch (InterruptedException e) {}// thread uspavan na 3 sekunde da bi drugi thread mogao da izvrsi istu operaciju
				appointmentService.scheduleAppointment(appointmentSchedule);// bacice ObjectOptimisticLockingFailureException

			}
		});
		executor.submit(new Runnable() {

			@Override
			public void run() {
				System.out.println("Startovan Thread 2");
				Appointment appointmentSchedule = appointmentService.findById(1L);// ocitan isti objekat sa id 1 kao i iz prvog threada
				appointmentService.scheduleAppointment(appointmentSchedule);
			}
		});
		try {
			future1.get(); // podize ExecutionException za bilo koji izuzetak iz prvog child threada
		} catch (ExecutionException e) {
			System.out.println("Exception from thread " + e.getCause().getClass()); // u pitanju je bas ObjectOptimisticLockingFailureException
			throw e.getCause();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		executor.shutdown();
		});

	}


}
