# Github Repository Project

Github Repository Project is an application which returns every github repository that isn't a fork of a provided user.

# Installation

To be used with IDE.
The application wasn't deployed or installed.

## Usage

```java
#Input
GET "http://localhost:8080/allRepositories?user=Marcin37"

#Expected Output
[
    {
        "name": "CryptoCurrencyBot",
        "owner": {
            "login": "Marcin37"
        },
        "branches": [
            {
                "name": "master",
                "commit": {
                    "sha": "d3449cbca4bb5dd81f57c977a6aedbb0f1f46ac7"
                }
            }
        ]
    },
    {
        "name": "RepositoryProject",
        "owner": {
            "login": "Marcin37"
        },
        "branches": [
            {
                "name": "main",
                "commit": {
                    "sha": "b7c8e1eba5379e2cf38aa5f5c52a3dc6f8ced8a0"
                }
            }
        ]
    }
]

#Input
GET "http://localhost:8080/allRepositories?user=Non-existinguser"

#Expected Output
{
    "status": 404,
    "message": "Non-existing github user"
}

```

## Contributing

Pull requests are welcome. For major changes, please open an issue first
to discuss what you would like to change.
