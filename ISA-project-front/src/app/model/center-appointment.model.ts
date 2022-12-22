export class Appointment {
    public startTime: String = ''; 
    public endTime: String = '';
    public id: number = 0;

    public constructor(obj?: any) {
        if (obj) {
            this.startTime = obj.startTime;
            this.endTime = obj.endTime;
            this.id = obj.id;
        }
    }
}