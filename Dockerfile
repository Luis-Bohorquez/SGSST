FROM eclipse-temurin:17-jdk
WORKDIR /app

COPY src/ ./src/
COPY lib/ ./lib/

RUN mkdir -p out && \
    javac -d out -cp ".:lib/postgresql-42.7.3.jar" src/com/sgsss/modelo/*.java src/com/sgsss/dao/*.java src/com/sgsss/vista/*.java

CMD ["java", "-cp", "out:lib/postgresql-42.7.3.jar", "com.sgsss.vista.SistemaPrincipal"]
