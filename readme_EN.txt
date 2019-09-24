--------------------------------
[Version]
--------------------------------
Version 201909

- Change logs
-----------
2019/09/25:
- 201909 is now available.

--------------------------------
[Overview]
--------------------------------
These code samples show how to use Java to call APIs.
Using JAX-WS to call API.

--------------------------------
[Contents]
--------------------------------
src/main/
  - resources/
    - api_config.properties.dist    : Config files to specify Ids. Rename this file to "api_config.properties"
  - java/jp/yahooapis/ss/
    - v201909/                      : Java Entity classes for written versions(V201909).
    - adapisample/
      - basic/                      : Examples of each services.
      - feature/                    : Examples of how to create ads, set targeting.
      - repository/                 : Utilities which help you use the code samples.
      - util/                       : Utilities which help you use the code samples.
download/                           : Directory where downloaded files stored when using download feature.
upload/                             : Directory where uploaded files stored when using upload feature.

--------------------------------
[Feature]
--------------------------------
src/main/java/jp/yahooapis/ss/adapisample/feature/
  - AdCustomizerSample.java                     : Examples of AdCustomizer features.
  - AdDisplayOptionSample.java                  : Examples of AdDisplayOption features.
  - AdSample.java                               : Examples of AdvancedUrl features.
  - DynamicAdsForSearchSample.java              : Examples of DynamicAdsForSearch features.
  - LabelSample.java                            : Examples of Label features.
  - SharedNegativeCampaignCriterionSample.java  : Examples of SharedNegativeCampaignCriterion features.
  - SiteRetargetingSample.java                  : Examples of SiteRetargeting features.
  - StructuredSnippetSample.java                : Examples of StructuredSnippet features.


--------------------------------
[Development environment]
--------------------------------
Install the softwares below to organize environment.

1. Java 1.8(Java SE Development Kit 8 or above
2. Apache Maven 3.1.1 or above
3.  Write Ids in  src/main/resources/api_config.properties.
  - LOCATION            : choose either sandbox or production environment by removing comment out.
  - LICENSE             : API license
  - APIACCOUNTID        : API account id
  - APIACCOUNTPASSWORD  : API account password
  - ONBEHALFOFACCOUNTID : On Behalf Of Account Id(optional)
  - ONBEHALFOFPASSWORD  : On Behalf Of Password(optional)
  - ACCOUNTID           : AccountId(required)

--------------------------------
[How to execute Sample Code]
--------------------------------
Move into the directory where you cloned and execute the command below.
$ mvn clean install

- Example
$ java -classpath ./target/classes jp.yahooapis.ss.adapisample.basic.account.AccountServiceSample
$ java -classpath ./target/classes jp.yahooapis.ss.adapisample.feature.AdSample
