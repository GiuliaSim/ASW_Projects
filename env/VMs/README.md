# Artemis

Questo è un ambiente di esecuzione per applicazioni Java, 
ed è composto da due macchine virtuali: 
un message broker **Artemis** e un **Client**. 

## Descrizione delle macchine virtuali 

### Artemis

La macchina virtuale **Artemis** 
contiene un message broker
che offre il servizio middleware per il messaging
ed ha il seguente software: 

* Ubuntu 16.04 LTS a 64 bit (by Bento) 

* Oracle Java SDK 

* Apache ActiveMQ Artemis 2.6.0 

Configurazione di rete 

* Indirizzo IP: 10.11.1.111 

* Porte pubblicate sull'host: 8080 
 
### Client

La macchina virtuale **Client**  
serve per l'esecuzione di applicazioni Java *lato client*, 
ed ha il seguente software: 

* Ubuntu 16.04 LTS a 64 bit (by Bento) 

* Oracle Java SDK 

* Apache Maven 3.5.3

* altre librerie client

Configurazione di rete 

* Indirizzo IP: 10.11.1.112 

