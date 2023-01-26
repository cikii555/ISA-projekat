package com.javaguide.ISAprojekat;

import com.javaguide.ISAprojekat.dto.AppointmentDTO;
import com.javaguide.ISAprojekat.model.*;
import com.javaguide.ISAprojekat.service.AppointmentService;
import com.javaguide.ISAprojekat.service.BloodDonationAppointmentService;
import com.javaguide.ISAprojekat.service.BloodTransfusionCenterService;
import com.javaguide.ISAprojekat.service.MedicalStaffService;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.junit.jupiter.api.Test;
import org.springframework.orm.ObjectOptimisticLockingFailureException;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;
import java.time.LocalDateTime;
import java.util.*;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import static org.junit.jupiter.api.Assertions.assertThrows;
@ExtendWith(SpringExtension.class)
@SpringBootTest
public class AdminSchedulingTests {
    @Autowired
    private  BloodDonationAppointmentService bloodDonationAppointmentService;
    @Autowired
    private MedicalStaffService medicalStaffService;
    @Autowired
    private AppointmentService appointmentService;
    @Autowired
    private BloodTransfusionCenterService bloodTransfusionCenterService;






    @Test
    public void testOptimisticLockingScenario() throws Throwable {

        ExecutorService executor = Executors.newFixedThreadPool(2);
        Future<?> future1 = executor.submit(new Runnable() {
            LocalDateTime localDateTime1 = LocalDateTime.of(
                    2023, 01, 24, 14, 33, 48, 123456789);
            LocalDateTime localDateTime2 = LocalDateTime.of(
                    2023, 01, 24, 14, 33, 48, 123456789);










            @Override
            public void run() {
                System.out.println("Startovan Thread 1");


                LocalDateTime localDateTime1 = LocalDateTime.of(
                        2023, 01, 24, 14, 33, 48, 123456789);
                LocalDateTime localDateTime2 = LocalDateTime.of(
                        2023, 01, 22, 14, 33, 48, 123456789);
                MedicalStaff doctor = new MedicalStaff(1,"marko", "markomarko@gmail.com", "Aljosa", "Pavlovic", "123456789",  "1122336655", "male" );
                MedicalStaff doctor1 = new MedicalStaff(2,"marko", "markomarko@gmail.com", "Milos", "Pavlovic", "123456789",  "1122336655", "male" );
                medicalStaffService.save(doctor);
                medicalStaffService.save(doctor1);
                BloodTransfusionCenter center = new BloodTransfusionCenter(1);
                bloodTransfusionCenterService.save(center);
                List<MedicalStaff> medicalStaffSet = medicalStaffService.findAll();
                //BloodTransfusionCenter center = bloodTransfusionCenterService.findOne(11);
                Set<MedicalStaff> foo = new HashSet<>(medicalStaffSet);
                Appointment appointment = new Appointment(foo,localDateTime1,localDateTime2,false,center);

               // izmenjen ucitan objekat
                try { Thread.sleep(3000); } catch (InterruptedException e) {}// thread uspavan na 3 sekunde da bi drugi thread mogao da izvrsi istu operaciju
                bloodDonationAppointmentService.saveAppointment(appointment);// bacice ObjectOptimisticLockingFailureException

            }
        });
        executor.submit(new Runnable() {

            @Override
            public void run() {
                System.out.println("Startovan Thread 2");
                LocalDateTime localDateTime1 = LocalDateTime.of(
                        2023, 01, 24, 14, 33, 48, 123456789);
                LocalDateTime localDateTime2 = LocalDateTime.of(
                        2023, 01, 22, 14, 33, 48, 123456789);
                MedicalStaff doctor = new MedicalStaff(1,"marko", "markomarko@gmail.com", "Aljosa", "Pavlovic", "123456789",  "1122336655", "male" );
                MedicalStaff doctor1 = new MedicalStaff(2,"marko", "markomarko@gmail.com", "Milos", "Pavlovic", "123456789",  "1122336655", "male" );
                medicalStaffService.save(doctor);
                medicalStaffService.save(doctor1);
                BloodTransfusionCenter center = new BloodTransfusionCenter(1);
                bloodTransfusionCenterService.save(center);
                List<MedicalStaff> medicalStaffSet = medicalStaffService.findAll();
                //BloodTransfusionCenter center = bloodTransfusionCenterService.findOne(11);
                Set<MedicalStaff> foo = new HashSet<>(medicalStaffSet);
                Appointment appointment = new Appointment(foo,localDateTime1,localDateTime2,false,center);
                // ocitan isti objekat sa id 1 kao i iz prvog threada
                bloodDonationAppointmentService.saveAppointment(appointment);
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

    }
}
