export class FutureAppointments {
    public startTime: String = ''; 
    public endTime: String = '';
    public bloodCenterName: String = '';
    public appointmentId: number = 0;
    public historyId: number = 0;

    public constructor(obj?: any) {
        if (obj) {
            this.startTime = obj.startTime;
            this.endTime = obj.endTime;
            this.bloodCenterName = obj.bloodCenterName;
            this.appointmentId = obj.appointmentId;
            this.historyId = obj.historyId;
        }
    }
}