# Arkkitehtuurikuvaus

Millanen on ohjelman rakenne?

## Rakenne
  
## Käyttöliittymä

## Sovelluslogiikka

![alt text](https://github.com/joonissi/ot-harjoitustyo/blob/master/dokumentaatio/luokkakaavio.png "luokkakaavio")  
  
## Tietojen tallennus  

Pakkauksen opinnot.dao luokat SQLUserDao ja SQLCourseDao huolehtivat tietojen tallentamisesta SQLite3-tietokantaan.  
  
Luokat noudattavat Data Access Model -suunnittelumallia. Tämä on tehty siksi, että tulevaisuudessa tallennustapa on mahdollista  
vaihtaa vain pienillä muutoksilla ohjelmakoodiin. Luokat ovat eriytetty rajapintojen taakse eikä sovelluslogiikka käytä luokkia suoraan.

## Tiedostot

Ohjelma tallentaa tiedot opinnot.db -tiedostoon joka toimii paikallisena tietokantana. Tietokannassa on tietotaulut suunnitelluille User -ja Course luokille.  
User taulun skeema on seuraava:

id, username, password  
  
1 | kayttaja | salasana |
  

## Ohjelman rakenteeseen jääneet heikkoudet
  
  
