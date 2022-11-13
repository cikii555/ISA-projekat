import { Time } from "@angular/common";

export class TransfusionCenter {
    public name:String = '';
    public country:String = '';
    public city:String = '';
    public street:String = '';
    public streetNumber:String = '';
    public description:String = '';
    public averageGrade:number = 0;
    public startTime:String = '';
    public endTime: String = '';

    public constructor(obj?: any) {
        if (obj) {
            this.name = obj.name;
            this.country = obj.country;
            this.city = obj.city;
            this.street = obj.street;
            this.streetNumber = obj.streetNumber;
            this.description = obj.description;
            this.averageGrade = obj.averageGrade;
            this.startTime = obj.startTime;
            this.endTime = obj.endTime;
        }
    }
}