--------------------------------
【バージョン】
--------------------------------
Version 201901

■変更履歴
-----------
2019/01/29:
- Version 201901に対応しました。

--------------------------------
【概要】
--------------------------------
このサンプルプログラムは、Javaを使用して各APIを呼び出す処理のサンプルです。
JAX-WSを使用してAPIを呼び出します。


--------------------------------
【内容物】
--------------------------------
src/main/
  - resources/
    - api_config.properties.dist    : 各種IDを記述する設定ファイルです、api_config.propertiesにリネームして下さい。
  - java/jp/yahooapis/ss/
    - v201901/                      : 対象のAPIバージョンのJava用EntityサンプルClassです。
    - adapisample/
      - basic/                      : プロモーション広告APIの各種Serviceサンプル集です。
      - feature/                    : プロモーション広告APIを利用した広告入稿、ターゲティングなどのサンプル集です。
      - repository/                 : プロモーション広告API各種サンプルを利用するための補助ユーティリティです。
      - util/                       : プロモーション広告API各種サンプルを利用するための補助ユーティリティです。
download/                           : 各種Downloadサービスを実行した際に、ダウンロードしたデータがファイルとして格納されるディレクトリです。
upload/                             : 各種Uploadサービスを実行する際に、利用するデータファイルを格納するディレクトリです。


--------------------------------
【Feature説明】
--------------------------------
src/main/java/jp/yahooapis/ss/adapisample/feature/
  - AdCustomizerSample.java                     : データ自動挿入機能を利用した入稿処理のサンプルです。
  - AdDisplayOptionSample.java                  : 広告表示オプションを利用した入稿処理のサンプルです。
  - AdSample.java                               : アドバンスドURLシステムを利用した入稿処理のサンプルです。
  - DynamicAdsForSearchSample.java              : 動的検索連動型広告を利用した入稿処理のサンプルです。
  - LabelSample.java                            : ラベル機能を利用した処理のサンプルです。
  - SharedNegativeCampaignCriterionSample.java  : 対象外キーワード共有機能を利用した処理のサンプルです。
  - SiteRetargetingSample.java                  : サイトリターゲティング機能を利用した処理のサンプルです。
  - StructuredSnippetSample.java                : カテゴリ補足オプションを利用した入稿処理のサンプルです。


--------------------------------
【環境設定】
--------------------------------
Java環境を構築するために、以下をインストールしてください。

1. Java 1.8 Java SE Development Kit 8、またはそれ以上のバージョン
2. Apache Maven 3.1.1、またはそれ以上のバージョン
3. resourcesディレクトリ配下にあるapi_config.propertiesに各IDを記述します。
  - LOCATION            : リクエスト先ごとにコメントアウトを外してください。
  - LICENSE             : APIライセンスを記述してください。
  - APIACCOUNTID        : APIアカウントIDを記述してください。
  - APIACCOUNTPASSWORD  : APIアカウントパスワードを記述してください。
  - ONBEHALFOFACCOUNTID : 代行アカウントを記述してください（任意）。
  - ONBEHALFOFPASSWORD  : 代行アカウントパスワードを記述してください（任意）。
  - ACCOUNTID           : アカウントIDを記述してください(必須)。


--------------------------------
【実行】
--------------------------------
cloneしたサンプルプログラムのディレクトリに移動し、以下のコマンドを実行します。
$ mvn clean install

各サンプルプログラムを実行します。

■実行例
$ java -classpath ./target/classes jp.yahooapis.ss.adapisample.basic.account.AccountServiceSample
$ java -classpath ./target/classes jp.yahooapis.ss.adapisample.feature.AdSample
