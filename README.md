# Recipe Finder App

Recipe Finder App est une application web développée avec Spring Boot qui permet aux utilisateurs de rechercher des recettes à partir d’un ingrédient.  
Elle utilise l’API [TheMealDB](https://www.themealdb.com/) pour afficher dynamiquement des recettes dans une interface moderne et responsive.

## Fonctionnalités

- Recherche de recettes par ingrédient (ex : `chicken`, `rice`, etc.)
- Affichage d’une liste de plats avec image, nom et instructions de préparation
- Interface moderne avec cartes animées et responsive design
- Intégration complète avec l’API publique TheMealDB


## 1. Exécution locale sans Docker

### Prérequis

- Java 17 installé  
- Maven installé  
- MySQL installé et en cours d'exécution

### Étapes

1. Cloner le projet :

   ```bash
   git clone https://github.com/AhmedBourazza/Recipes-project
   cd recipes-app
  
2. Créer la base de données MySQL :
   ```bash
   CREATE DATABASE bdrecipes;
3. Configurer application.properties :

     ```bash
    spring.datasource.url=jdbc:mysql://localhost:3306/bdrecipes?serverTimezone=UTC
    spring.datasource.username=root
    spring.datasource.password=root

4. Lancer l'application avec Maven :

     ```bash
    mvn spring-boot:run

5. Accéder à l'application :
Ouvre ton navigateur et accède à http://localhost:8080/login.

## 1. Exécution avec Docker
2. Exécution avec Docker
Utiliser l’image depuis Docker Hub

Pull de l’image :

     ```bash
    docker pull ahmedbourazza/recipes-app:latest
Lancer le conteneur :

docker run -p 8080:8080 ahmedbourazza/recipes-app:latest
Assure-toi que ta base MySQL est déjà lancée et accessible.




