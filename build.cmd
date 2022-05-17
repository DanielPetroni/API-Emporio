echo Deletando Jar existente de docker
cd src/main/docker
del *.jar
cd ../../../
wait mvn clean package
cd targetclea
echo Movendo Jar para docker
move api-emporio-0.0.1-SNAPSHOT.jar /src/main/docker