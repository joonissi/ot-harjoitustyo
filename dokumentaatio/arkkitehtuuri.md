# Arkkitehtuurikuvaus

Millanen on ohjelman rakenne?

## Rakenne
  
## Käyttöliittymä

## Sovelluslogiikka
Ohjelman datamalliin kuuluu User -ja Course luokat. Näissä luokissa kuvataan käyttäjän suorittamia kursseja.  
![alt text](https://github.com/joonissi/ot-harjoitustyo/blob/master/dokumentaatio/luokkakaavio.png "luokkakaavio")  
  
Ohjelman pakkauskaavio  
![alt text](https://github.com/joonissi/ot-harjoitustyo/blob/master/dokumentaatio/pakkauskaavio.png "pakkauskaavaio")  
  
## Tietojen tallennus  

Pakkauksen opinnot.dao luokat SQLUserDao ja SQLCourseDao huolehtivat tietojen tallentamisesta SQLite3-tietokantaan.  
  
Luokat noudattavat Data Access Model -suunnittelumallia. Tämä on tehty siksi, että tulevaisuudessa tallennustapa on mahdollista  
vaihtaa vain pienillä muutoksilla ohjelmakoodiin. Luokat ovat eriytetty rajapintojen taakse eikä sovelluslogiikka käytä luokkia suoraan.

## Tiedostot

Ohjelma tallentaa tiedot opinnot.db -tiedostoon joka toimii paikallisena tietokantana. Tietokannassa on tietotaulut suunnitelluille User -ja Course luokille.  
User taulun skeema on seuraava:
  
id, username, password  
  
1 | kayttaja | salasana |  
  
  
Course taulun skeema on seuraava:  
  
id, name, points, done, user_id  
  
1| ohjelmointi| 5| true| 1|
  

## Ohjelman rakenteeseen jääneet heikkoudet
Ohjelmaan jäi vielä parannettavaa. Muutama bugi jäi ohjelmaan, mutta eivät haittaa sen peruskäyttöä.
Ohjelmaa voisi vielä refactoroida joka toisi sille selkeyttä ja olisi tällöin helpommin laajennettavissa.
  
