# Testausdokumentti

Ohjelmaa on testattu yksikkötestein jUnit-kirjastolla. Myös manuaalista testausta on suoritettu ohjelman kehitysvaiheessa.

## Yksikkö- ja integraatiotestaus

### sovelluslogiikka

Sovelluslogiikkaa on testattu yksikkötestein ja muutamilla integraatiotesteillä.  

### DAO-luokat

DAO-luokkia on testattu oikealla tietokannalla, mutta tätä voisi tulevaisuudessa tehdä omalla testeihin soveltuvalla täysin eristetyllä tietokannalla. 

### Testauskattavuus

Testauskattavuuteen ei olla laskettu sovelluksen käyttöliittymää jolloin rivikattuvuus on 39% ja haarautumakattavuus 23%
![alt text](https://github.com/joonissi/ot-harjoitustyo/blob/master/dokumentaatio/testauskattavuus.png "testikattavuus")

## Järjestelmätestaus

Järjestelmätestaus on tehty manuaalisesti sovelluksen kehitysvaiheessa.

### Asennus ja kanfigurointi

Asennusta ei tarvitse erikseen tehdä. Ohjelma pitää vain käynnistää käyttöohjeen mukaan. Ohjelma on tämän takia testattu manuaalisesti ilman tarvittavia konfiguraatioita ja niiden kanssa. Näin on saatu varmuus, että ohjelma toimii molemmissa tapauksissa. 

### Toiminnallisuudet

Ohjelmaa on pyritty testaamaan mahdollisimman laajasti. Tietokantaan liittyvissä metodeissa on jäänyt joitain alueita vähemmälle testaukselle, mutta on pyritty korvaamaan manuaalisella testauksella.

## Sovellukseen jääneet laatuongelmat

Hieman suppuean testikattavuuden takia ohjelmaan jäi muutamia seikkoja huomiotta, mutta onneksi ovat enemmän kosmisia ongelmia.  
