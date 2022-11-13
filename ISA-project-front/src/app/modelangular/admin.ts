export interface IAdmin {
  firstName: string ,
  lastName: string,
  username: string,
  email: string,
  id: number,
  phoneNumber:string,
  address: {
    id:number,
    country: string,
    city: string,
    street: string,
    streetNumber:number
  }
}
