export class RegClient {
    public password:String = '';
    public email: String = '';
    public firstName:String = '';
    public lastName:String = '';
    public phoneNumber:String = '';
    public country:String = '';
    public city:String = '';
    public street:String = '';
    public streetNumber:String = '';
    public jmbg:String = '';
    public gender:String = '';
    public occupation:String = '';
    public organizationInformation:String = '';


    public constructor(obj?: any) {
        if (obj) {
            this.password = obj.password;
            this.email = obj.email;
            this.firstName = obj.firstName;
            this.lastName = obj.lastName;
            this.phoneNumber = obj.phoneNumber;
            this.country = obj.country;
            this.city = obj.city;
            this.street = obj.street;
            this.streetNumber = obj.streetNumber;
            this.jmbg = obj.jmbg;
            this.gender = obj.gender;
            this.occupation = obj.occupation;
            this.organizationInformation = obj.organizationInformation;
        }
    }
}