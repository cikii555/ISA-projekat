# Internet Softverske Arhitekture - Projektni zadatak 2022/2023
* Članovi tima:
  * Dragana Kućanski RA 164/2019
  * Dušan Stanimirović RA 173/2019
  * Cvetana Despinić RA 176/2019
 
 ## Tehnologije korišćene prilikom izrade projekta
- Spring Boot
- Angular
- PostgreSQL

## Porektanje aplikacije: 
- Prvo se pokreće serverski deo aplikacije tako što se otvori projektni folder u IntelliJ razvojnom okruženju, i zatim se pritiskom na dugme _Run_ pokreće server na portu _:8080_.
- Potrebno je instalirati sve dependency-je da bi se server mogao uspešno pokrenuti.
- Zatim se pokreće klijentski deo aplikacije tako što se projektni folder (ISA-project-front) otvara u razvojnom okruženju Visual Studio Code
- Potrebno je, ukoliko nije prisutan, instalirati node.js
- Zatim unutar konzole komandom _npm install_ instalirati sve zahtevane biblioteke
- Na kraju potrebno je ukucati komandu _ng serve -o_ koja će pokrenuti klijentsku aplikaciju na portu _:4200_

## Baza - PostgreSQL
- Server baze podataka radi na podrazumevanom portu `5432`
- Nakon pokretanja pgAdmin-a, potrebno je kreirati bazu podataka pod nazivom `ISA-project` 
- Korisničko ime : `postgres`, lozinka : `123`
- Uz projekat je priložena data-postgres.sql skripta za popunjavanje baze potrebnim podacima
