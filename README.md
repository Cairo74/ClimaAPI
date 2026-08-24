# ClimaAPI

Projeto DIAW 1 — API REST em Spring Boot que consulta a previsão do tempo de **Belo Horizonte (MG)** usando a API pública [Open-Meteo](https://open-meteo.com/).

---

## Tecnologias e dependências

- **Java 25**
- **Spring Boot 4.1.1**
- **Maven** (via Maven Wrapper — não precisa instalar)
- `spring-boot-starter-webmvc` — criação da API REST e chamadas HTTP com `RestTemplate`
- `spring-boot-starter-webmvc-test` (escopo `test`) — testes
- **API externa:** Open-Meteo Forecast API

---

## Pré-requisitos

- JDK 25 instalado e configurado (`java -version`)
- Não é necessário instalar o Maven: o projeto já traz o wrapper (`mvnw` / `mvnw.cmd`)

---

## Como executar localmente

Na raiz do projeto:

**Windows (PowerShell / CMD)**
```bash
.\mvnw.cmd spring-boot:run
```

**Linux / macOS**
```bash
./mvnw spring-boot:run
```

Alternativa — gerar o `.jar` e executar:

```bash
.\mvnw.cmd clean package
java -jar target/ClimaAPI-0.0.1-SNAPSHOT.jar
```

A aplicação sobe em **http://localhost:8080**.

---

## Configuração da API Key

**Não é necessária nenhuma API Key.** A Open-Meteo é gratuita e aberta para uso não comercial, então o projeto funciona sem cadastro, chave ou variável de ambiente.

## Endpoints
 `GET``/clima` | Retorna a previsão do tempo de Belo Horizonte para hoje

### Exemplo de chamada

```bash
curl http://localhost:8080/clima
```

Ou abra no navegador: http://localhost:8080/clima

### Exemplo de resposta (resumido)

```json
{
  "latitude": -19.9208,
  "longitude": -43.9378,
  "timezone": "America/Sao_Paulo",
  "hourly": {
    "time": ["2026-08-24T00:00", "2026-08-24T01:00"],
    "temperature_2m": [18.4, 18.1],
    "relative_humidity_2m": [82, 84],
    "wind_speed_10m": [6.5, 5.9],
    "wind_direction_10m": [120, 118]
  },
  "daily": {
    "time": ["2026-08-24"],
    "temperature_2m_max": [27.3],
    "temperature_2m_min": [16.8],
    "weather_code": [2]
  }
}
```

Campos retornados:

- `temperature_2m` — temperatura por hora (°C)
- `relative_humidity_2m` — umidade relativa por hora (%)
- `wind_speed_10m` / `wind_direction_10m` — velocidade e direção do vento
- `temperature_2m_max` / `temperature_2m_min` — máxima e mínima do dia
- `weather_code` — código da condição do tempo (padrão WMO)

---

## Estrutura do projeto

```
src/main/java/com/example/ClimaAPI/
├── ClimaApiApplication.java      # classe principal (Spring Boot)
├── controller/Controller.java    # endpoint GET /clima
└── service/Service.java          # consome a API da Open-Meteo
```

# Autores

- Cairo Rodrigues Rezende
- Pedro José de Magalhães Tavares Camilo