# dev-tech-challenge

Challenge "développeur web avancé" : Constituez l'équipage !

### **Configuration**

La configuration de l'application se fait à travers le fichier `application.yaml`.

- configuration à la base de donnée

```
    spring:
      datasource:
        username: postgres                           # le nom d'utilisateur de la base de donnée
        password: postgres                           # mot de passe de la base donnée
        url: jdbc:postgresql://localhost:5432/dummy  # l'url de connexion à la base de donnée
```

- configurer ou changer le port de démarrage par défaut

```
    server:
      port: 8081  # port de démarrage
```