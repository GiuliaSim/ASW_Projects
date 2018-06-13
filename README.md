# Progetto Architettura dei Sistemi Software - Roma Tre (2018)

Questo repository contiene il codice del *progetto* 
del corso di [Architettura dei Sistemi Software](http://cabibbo.dia.uniroma3.it/asw/), 
relativo ad *applicazioni distribuite* basate sull'uso di *Api JMS* 
implementate dal servizio di middleware [Apache Artemis](https://activemq.apache.org/artemis/): 
* il software è scritto in [Java](http://www.oracle.com/technetwork/java/index.html), 
  e costruito con [Maven](https://maven.apache.org/); 
* l'ambiente di esecuzione distribuito è composto 
  da due macchine virtuali create con 
  [VirtualBox](https://www.virtualbox.org/)
  e [Vagrant](https://www.vagrantup.com/).

## Software da installare sul proprio PC per la gestione degli ambienti di esecuzione  

* [VirtualBox](https://www.virtualbox.org/)
* [Vagrant](https://www.vagrantup.com/) 

## Organizzazione del repository 

Questo repository è organizzato in due sezioni principali: 
* [proj](proj/) contiene il codice delle *applicazioni distribuite*
	e i relativi file *jar*; 
* [env](env/) contiene il codice per la gestione delle macchina virtuali:
  *Artemis* e *Client* che permettono l'esecuzione delle applicazioni distribuite sviluppate. 
  

## Creazione dell'ambiente di esecuzione

L'ambiente di esecuzione è composto da due macchine virtuali, 
collegate in una rete privata. 

Gli ambienti vengono creati con **Vagrant**.

Per gestire l'ambiente distribuito bisogna:

1. usare una shell del proprio PC 

2. posizionarsi nella cartella dell'[ambiente](env/VMs/)

3. per avviare l'ambiente di esecuzione:

	3.1 usare il comando `vagrant up Artemis` per creare e/o avviare la macchina virtuale *Artemis*

	3.2 usare il comando `vagrant up Client` per creare e/o avviare la macchina virtuale *Client*

4. per collegarsi con SSH alla macchina virtuale *Client* dell'ambiente, usare il comando `vagrant ssh Client`
    
E' anche possibile: 

* arrestare l'ambiente di esecuzione, con il comando `vagrant halt`

* distruggere l'ambiente di esecuzione, con il comando `vagrant destroy -f` 

## Build delle applicazioni

I **progetti** si trovano 
nella cartella **/home/asw/projects/** oppure nella cartella **projects/** dell'utente di default. 

La costruzione (build, ovvero compilazione e assemblaggio) delle applicazioni 
va fatta applicazione per applicazione, 
utilizzando **Maven**. 
Tenendo conto che l'ordine in cui vengono costruite le applicazioni deve essere il seguente:

1. asw-util

2. asw-jndi

3. simple-producer

4. simple-synch-consumer

5. simple-asynch-consumer

6. simple-filter

7. message-queue-browser

8. multiple-producers-consumers


Per compilare un'applicazione bisogna: 

1. collegarsi con `vagrant ssh` alla macchina virtuale **Client** 
   dell'ambiente distribuito, su cui sono installati *Java SDK* e *Maven* 

2. posizionarsi nella cartella principale dell'applicazione di interesse 

3. per compilare e assemblare l'applicazione, usare il comando `mvn install` 

E' anche possibile: 

* ripulire la build di un'applicazione, con il comando `mvn clean`


## Esecuzione 

Il risultato della costruzione di un'applicazione 
è composto da un **componente eseguibile**, 
che dopo la costruzione è disponibile nella cartella *projects/jar*,
contenente il file *jar* dell'applicazione. 

In alternativa, nella cartella [jar](proj/jar/) 
sono già presenti i file eseguibili senza dover effetturare la **build**.

Ciascun componente eseguibile va poi mandato in esecuzione 
nell'ambito della macchina virtuale *Client* dell'ambiente distribuito. 

Per eseguire le applicazioni:

* Collegarsi con SSH alla macchina virtuale *Client* dell'ambiente

* Posizionarsi nella cartella contenente i jar dei progetti con il comando `cd projects/jar/`;

* Eseguire il file jar **.jar* con il comando `java -jar *.jar` 
(ad esempio, **java -jar simple-producer-0.0.1-SNAPSHOT-jar-with-dependencies.jar**)

