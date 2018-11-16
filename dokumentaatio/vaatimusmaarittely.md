# Vaatimusmäärittely

## Sovelluksen tarkoitus

Sovelluksella opiskelija voi kirjautuessaan seurata omien opintojensa kulkua. Sovellusta on mahdollista käyttää eri käyttäjätunnusten avulla. Vain omat suoritukset
näkyvät kirjautuneelle käyttäjälle.

## Käyttäjät

Alussa sovelluksessa on vain yksi käyttäjärooli jolla voi katsoa, lisätä, muokata ja poistaa omia suorituksiaan. Myöhemmin ohjelmaan on mahdollista,
lisätä muitakin käyttäjärooleja. Toisenlainen käyttäjärooli voisi olla esimerkiksi *pääkäyttäjä* joka voi hallinnoida koko järjestelmää ja sen tietoja.

## Käyttöliittymäluonnos

Sovelluksessa on eri näkymiä jotka ovat kuvattuna alla olevassa kuvassa tarkemmin.  
  
![alt text](https://github.com/adam-p/markdown-here/raw/master/src/common/images/icon48.png "Logo Title Text 1")

   

## Perusversion tarjoama toiminnallisuus

### Ennen kirjautumista
- Käyttäjä voi luoda itselleen uuden käyttäjätunnuksen
    - Uusi käyttäjätunnus ei saa olla ristiriidassa jo olemassa olevien tunnusten kanssa sekä sillä on minimipituutena kolme merkkiä
- Käyttäjä voi kirjautua järjestelmään
    - Oikean tunnuksen ja salasanan syötettyään käyttäjä ohjautuu näkymään missä voi tehdä eri toimenpiteitä opintoihinsa liittyen
    - Mikäli tunnus on väärä tai sitä ei ole olemassa siitä kerrotaan käyttäjälle

### Kirjautumisen jälkeen
- Käyttäjä näkee omat opintonsa
- Käyttäjä voi luoda uuden opinnon
    - Vain käyttäjä itse näkee omat opintonsa
- Käyttäjä voi muokata opintojansa
- Käyttäjä voi poistaa opinnon listalta
- Käyttäjä voi kirjautua ulos järjestelmästä
  

## Jatkokehitysideoita

Perusversion jälkeen mahdollisesti toteutettavia ominaisuuksia:

- statistiikka suorituksille
- Useita eri käyttäjärooleja (vieras, käyttäjä, pääkäyttäjä)
- Opintojen priorisointi
- Opintojen järjestäminen
