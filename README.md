# OT2018, harjoitustyö  

## Opintojen seurantajärjestelmä

Teen kurssilla ohjelman jolla voi seurata omien opintojen kulkua. Kirjoitan ohjelman Javalla ja käytän tiedon tallentamisessa
tietokantaa josta luetaan, muokataan, lisätään ja poistetaan kursseja. Tietokanta tallennetaan paikallisesti levylle, ja
tämän takia käytän tietokantana SQLite-tietokantaa. Ohjelman toimii paikallisesti käyttäjän tietokoneella, jossa on Java asennettuna.
  
Panostan tässä työssäni ohjelman dokumentointiin, aikataulun noudattamiseen ja ohjelman testaamiseen. Tulen käyttämään kaikki ylimenevän ajan ohjelman toiminnallisuuksien ja käyttäjäkokemuksen parantamiseen.


## Dokumentaatio
[Käyttöohje](https://github.com/joonissi/ot-harjoitustyo/blob/master/dokumentaatio/kayttoohje.md)  
[Vaatimusmäärittely](https://github.com/joonissi/ot-harjoitustyo/blob/master/dokumentaatio/vaatimusmaarittely.md)  
[Arkkitehtuurikuvaus](https://github.com/joonissi/ot-harjoitustyo/blob/master/dokumentaatio/arkkitehtuuri.md)  
[Testausdokumentti](https://github.com/joonissi/ot-harjoitustyo/blob/master/dokumentaatio/testaus.md)  
[Tuntikirjanpito](https://github.com/joonissi/ot-harjoitustyo/blob/master/dokumentaatio/tuntikirjanpito.md)  

## Releaset

[versio 2.0](https://github.com/joonissi/ot-harjoitustyo/releases/tag/2.0)

## Komentorivitoiminnot
Seuraavilla komennoilla voidaan suorittaa eri toimenpiteitä projektia varten.

### Testaus  
Testit projektille suoritetaan  
```
mvn test
```
Testikattavuus projektille suoritetaan  
```
mvn jacoco:report
```
  
### Suoritettavan jarin generointi  
Projektille generoidaan suoritettava jar-tiedosto komennolla (jar-tiedosto generoituu target kansioon)  
```
mvn package
```
  
###  JavaDoc  
JavaDoc projektille saadaan komennolla  
```
mvn javadoc:javadoc
```
  
### Checkstyle  
Checkstyle pitää huolta koodin laadusta ja tätä voi tarkkailla komennolla  
```
mvn jxr:jxr checkstyle:checkstyle
```
  


