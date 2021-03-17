# Data parser

Example of JSON data that was parsed is available at

`src/test/resources/data/data.json`

Following data is displayed for each hour of the day:

- **date** - ("date_applied" in JSON) - Date as miliseconds since start of epoch (start of day). Timezone seems to be Netherlands standard (with daylight saving).

- **hour** - based on either "Order" or "Hour" field.

- **net volume** - value used from "Net Volume" field.

- **price** - value used from "Price" field

For JSON parsing,[Jackson](https://en.wikipedia.org/wiki/Jackson_(API))

# **Basic steps**

Defined object models in Java (classes `QuoteResponse`, `Quote`, `QuoteValue`).

Implemented code to parse JSON into the object model.

Implemented uni test for the code (loaded from class path and verified if it was parsed correctly).

# **Building**

Maven was used

