export class Client {
    public password:String = '';
    public email: String = '';
    public firstName:String = '';
    public lastName:String = '';
    public phoneNumber:String = '';
    public jmbg:String = '';
    public gender:String = '';
    public occupation:String = '';
    public organizationInformation:String = '';
    public penalties:number = 0;


    public constructor(obj?: any) {
        if (obj) {
            this.password = obj.password;
            this.email = obj.email;
            this.firstName = obj.firstName;
            this.lastName = obj.lastName;
            this.phoneNumber = obj.phoneNumber;
            this.jmbg = obj.jmbg;
            this.gender = obj.gender;
            this.occupation = obj.occupation;
            this.organizationInformation = obj.organizationInformation;
            this.penalties = obj.penalty;
        }
    }
}