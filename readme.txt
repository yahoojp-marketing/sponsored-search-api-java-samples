--------------------------------
【License】
--------------------------------
本ライブラリおよびサンプルコード等は MIT License にて提供しています。
詳しくは LICENSE をご覧ください。

--------------------------------
【Pull request に関して】
--------------------------------
頂いたPull requestに対して、全てを必ず受け付けられるわけではございません。
ご了承ください。

--------------------------------
【バージョン】
--------------------------------
Ver5.2.0

■変更履歴
-----------
2015/05/20:
- Version5.2対応しました。
- Java1.8に対応しました。
- プロジェクトをMaven形式に変更しました。

2014/6/13:
- Version5.1に対応しました。

2013/12/15:
- Version5.0に対応しました。

2013/08/28:
- Version4.2追加API：AdGroupBidMultiplierServiceに対応しました。
- Soap APIライブラリをJAX-WSに変更しました。

2013/07/22:
- Version4.2に対応しました。V4.0からの変更点は以下になります。
-- AdDisplayOptionSample.javaの追加


--------------------------------
【概要】
--------------------------------
このサンプルプログラムは、Javaを使用して各APIを呼び出す処理サンプルです。
JAX-WSを使用してAPIを呼び出す形になっています。


--------------------------------
【内容物】
--------------------------------
■src/main/javaディレクトリ
以下の各プログラムが格納されています。

・以下は直接実行できるサンプルプログラムです。

- jp/co/yahoo/ad_api_sample配下
  - accountSample/AccountSample.java                     :AccountServiceによるアカウント参照、更新処理のサンプルです。
  - adCustomizerSample/AdCustomizerSample.java           :AdGroupAdService/FeedItemService/FeedFolderService/AdGroupCriterionService/AdGroupService/CampaignServiceによるデータ自動挿入機能の登録、参照、更新、削除処理のサンプルです。
  - adCustomizerSample/FeedFolderServiceSample.java      :FeedFolderServiceによるフィードフォルダーの登録、参照、更新、削除処理のサンプルです。
  - adCustomizerSample/FeedItemServiceSample.java        :FeedItemServiceによるフィードアイテムの登録、参照、更新、削除処理のサンプルです。
  - adDisplayOptionSample/AdDisplayOptionSample.java     :FeedItemService/CampaignFeedService/AdGroupFeedServiceによる広告表示オプションの登録、参照、更新処理のサンプルです。
  - adSample/AdSample.java                               :BiddingStrategyService/CampaignService/CampaignTargetService/CampaignCriterionService/AdGroupService/AdGroupCriterionService/AdGroupAdService/AdGroupBidMultiplierServiceによる入稿処理のサンプルです。
  - adSample/BiddingStrategyServiceSample.java           :BiddingStrategyServiceによる自動入札設定の登録、参照、更新、削除処理のサンプルです。
  - adSample/CampaignServiceSample.java                  :CampaignServiceによるキャンペーンの登録、参照、更新、削除処理のサンプルです。
  - adSample/CampaignTargetServiceSample.java            :CampaignTargetServiceによるキャンペーンターゲティング設定の登録、参照、更新、削除処理のサンプルです。
  - adSample/CampaignCriterionServiceSample.java         :CampaignCriterionServiceによるキャンペーン除外クライテリアの登録、参照処理のサンプルです。
  - adSample/AdGroupServiceSample.java                   :AdGroupServiceによる広告グループの登録、参照、更新、削除処理のサンプルです。
  - adSample/AdGroupCriterionServiceSample.java          :AdGroupCriterionServiceによる広告グループクライテリアの登録、参照、更新、削除処理のサンプルです。
  - adSample/AdGroupBidMultiplierServiceSample.java      :AdGroupBidMultiplierServiceによる広告グループ入札価格調整率の参照、更新処理のサンプルです。
  - adSample/AdGroupAdServiceSample.java                 :AdGroupAdServiceによる広告の登録、参照、更新、削除処理のサンプルです。
  - balanceSample/BalanceSample.java                     :BalanceServiceによるアカウント残高を参照する処理のサンプルです。
  - bidLandscapeSample/BidLandscapeSample.java           :BidLandscapeServiceによるビットのシュミレート情報を参照する処理のサンプルです。
  - bulkDownloadSample/BulkDownloadSample.java           :BulkServiceによるダウンロード処理のサンプルです。
  - bulkUploadSample/BulkUploadSample.java               :BulkServiceによるアップロード処理のサンプルです。
  - customerSyncSample/CustomerSyncSample.java           :CustomerSyncServiceによるアカウント、キャンペーン情報の更新履歴参照処理のサンプルです。
  - conversionTrackerSample/ConversionTrackerSample.java :ConversionTrackerServiceによるコンバージョントラック情報の登録、参照、更新処理のサンプルです。
  - dictionarySample/DictionarySample.java               :DictionaryServiceによる審査否認理由の参照、地域コード参照処理のサンプルです。
  - keywordEstimatorSample/KeywordEstimatorSample.java   :KeywordEstimatorServiceによるキャンペーン及び広告グループのキーワードのクリック単価や掲載順位などの予測値を参照する処理のサンプルです。
  - reportDownloadSample/ReportDownloadSample.java       :ReportDefinitionService, ReportServiceを使用したレポートダウンロード処理のサンプルです。
  - targetingIdeaSample/TargetingIdeaSample.java         :TargetingIdeaServiceによる推奨キーワードを参照する処理のサンプルです。
  - trafficEstimatorSample/TrafficEstimatorSample.java   :TrafficEstimatorServiceによる指定キーワードのクリック単価や掲載順位などの予測値を参照する処理のサンプルです。

・以下は各サンプルプログラムから利用されるクラスです。

- jp/co/yahoo/ad_api_sample配下
  - util/SoapUtils.java       :LocationServiceを使用したリクエスト先の取得処理のサンプル及びその他共通処理です。
  - jp/yahooapis/ss/V5配下           :JAX-WSを使用してWSDLから生成したスタブ、スケルトンクラス群です。

■src/main/resourceディレクトリ
以下の内容物が格納されています。

- binディレクトリ : コンパイルされたサンプルプログラムの実行ファイルと、Windows上で実行するためのバッチファイルが格納されています。
  - run_sample.bat               ：Windows上でサンプルプログラムを実行するためのバッチファイルです。
  - ad-api-sample-SS-API-V5.2.jar：コンパイルされたサンプルプログラムがまとめたjarファイルです。

- confディレクトリ : サンプルプログラム実行時の各種設定を記述するプロパティファイルが格納されています。
  - api_config.properties：各種IDを記述する設定ファイルです。

- downloadディレクトリ
  ReportDownloadSample、BulkDownloadSample、BulkUploadSampleを実行した際に、
    ダウンロードしたデータがファイルとして格納されるディレクトリです。

- uploadディレクトリ
  BulkUploadSampleでアップロードするファイルをあらかじめ格納しておくディレクトリです。

■src/test/javaディレクトリ
以下の各テストケースが格納されています。

・以下はsrc/main/java/jp/co/yahoo/ad_api_sample配下のサンプルプログラムをJUnitで実行できるテストケースです。

- jp/co/yahoo/ad_api_sample配下
  - accountSample/AccountSampleTest.java                     :AccountServiceによるアカウント参照、更新処理のテストケースです。
  - adCustomizerSample/AdCustomizerSampleTest.java           :AdGroupAdService/FeedItemService/FeedFolderService/AdGroupCriterionService/AdGroupService/CampaignServiceによるデータ自動挿入機能の登録、参照、更新、削除処理のテストケースです。
  - adCustomizerSample/FeedFolderServiceSampleTest.java      :FeedFolderServiceによるフィードフォルダーの登録、参照、更新、削除処理のテストケースです。
  - adCustomizerSample/FeedItemServiceSampleTest.java        :FeedItemServiceによるフィードアイテムの登録、参照、更新、削除処理のテストケースです。
  - adDisplayOptionSample/AdDisplayOptionSampleTest.java     :FeedItemService/CampaignFeedService/AdGroupFeedServiceによる広告表示オプションの登録、参照、更新処理のテストケースです。
  - adSample/AdSampleTest.java                               :BiddingStrategyService/CampaignService/CampaignTargetService/CampaignCriterionService/AdGroupService/AdGroupCriterionService/AdGroupAdService/AdGroupBidMultiplierServiceによる入稿処理のテストケースです。
  - adSample/BiddingStrategyServiceSampleTest.java           :BiddingStrategyServiceによる自動入札設定の登録、参照、更新、削除処理のテストケースです。
  - adSample/CampaignServiceSampleTest.java                  :CampaignServiceによるキャンペーンの登録、参照、更新、削除処理のテストケースです。
  - adSample/CampaignTargetServiceSampleTest.java            :CampaignTargetServiceによるキャンペーンターゲティング設定の登録、参照、更新、削除処理のテストケースです。
  - adSample/CampaignCriterionServiceSampleTest.java         :CampaignCriterionServiceによるキャンペーン除外クライテリアの登録、参照処理のテストケースです。
  - adSample/AdGroupServiceSampleTest.java                   :AdGroupServiceによる広告グループの登録、参照、更新、削除処理のテストケースです。
  - adSample/AdGroupCriterionServiceSampleTest.java          :AdGroupCriterionServiceによる広告グループクライテリアの登録、参照、更新、削除処理のテストケースです。
  - adSample/AdGroupBidMultiplierServiceSampleTest.java      :AdGroupBidMultiplierServiceによる広告グループ入札価格調整率の参照、更新処理のテストケースです。
  - adSample/AdGroupAdServiceSampleTest.java                 :AdGroupAdServiceによる広告の登録、参照、更新、削除処理のテストケースです。
  - balanceSample/BalanceSampleTest.java                     :BalanceServiceによるアカウント残高を参照する処理のテストケースです。
  - bidLandscapeSample/BidLandscapeSampleTest.java           :BidLandscapeServiceによるビットのシュミレート情報を参照する処理のテストケースです。
  - bulkDownloadSample/BulkDownloadSampleTest.java           :BulkServiceによるダウンロード処理のテストケースです。
  - bulkUploadSample/BulkUploadSampleTest.java               :BulkServiceによるアップロード処理のテストケースです。
  - customerSyncSample/CustomerSyncSampleTest.java           :CustomerSyncServiceによるアカウント、キャンペーン情報の更新履歴参照処理のテストケースです。
  - conversionTrackerSample/ConversionTrackerSampleTest.java :ConversionTrackerServiceによるコンバージョントラック情報の登録、参照、更新処理のテストケースです。
  - dictionarySample/DictionarySampleTest.java               :DictionaryServiceによる審査否認理由の参照、地域コード参照処理のテストケースです。
  - keywordEstimatorSample/KeywordEstimatorSampleTest.java   :KeywordEstimatorServiceによるキャンペーン及び広告グループのキーワードのクリック単価や掲載順位などの予測値を参照する処理のテストケースです。
  - reportDownloadSample/ReportDownloadSampleTest.java       :ReportDefinitionService, ReportServiceを使用したレポートダウンロード処理のテストケースです。
  - targetingIdeaSample/TargetingIdeaSampleTest.java         :TargetingIdeaServiceによる推奨キーワードを参照する処理のテストケースです。
  - trafficEstimatorSample/TrafficEstimatorSampleTest.java   :TrafficEstimatorServiceによる指定キーワードのクリック単価や掲載順位などの予測値を参照する処理のテストケースです。

■src/test/resourceディレクトリ
以下の内容物が格納されています。

- confディレクトリ : テストケース実行時の各種設定を記述するプロパティファイルが格納されています。
  - api_config.properties：各種IDを記述する設定ファイルです。

- downloadディレクトリ
  ReportDownloadSampleTest、BulkDownloadSampleTest、BulkUploadSampleTestを実行した際に、
    ダウンロードしたデータがファイルとして格納されるディレクトリです。

- uploadディレクトリ
  BulkUploadSampleTestでアップロードするファイルをあらかじめ格納しておくディレクトリです。


--------------------------------
【環境設定】
--------------------------------
Java環境を構築するために、以下をインストールしてください。

[Java 1.8(Java SE Development Kit 8)]
http://www.oracle.com/technetwork/java/javase/downloads/index.html

Maven環境を構築するために、以下をインストールしてください。

[Apache Maven 3.1.1]
https://maven.apache.org/download.cgi

confディレクトリ配下にあるapi_config.propertiesに各IDを記述します。

LOCATION            : リクエスト先毎にコメントアウトを外してください。
LICENSE             : APIライセンスを記述(必須)
APIACCOUNTID        : APIアカウントIDを記述(必須)
APIACCOUNTPASSWORD  : APIアカウントパスワードを記述(必須)
ONBEHALFOFACCOUNTID : 代行アカウントを記述(任意)
ONBEHALFOFPASSWORD  : 代行アカウントパスワードを記述(任意)
ACCOUNTID           : アカウントIDを記述(必須)

以下、IDはBidLandscapeSampleを動作させる際に必要となります。
BIDDINGSTRATEGYID   : 自動入札IDを記述（必須）
CAMPAIGNID          : キャンペーンIDを記述（必須）
ADGROUPID           : 広告グループIDを記述（必須）
ADGROUPCRITERIONIDS : 広告グループのクライテリアIDを記述（任意）
                      カンマ区切りで複数IDを指定することができます。

以下、IDはAdCustomizerSampleを動作させる際に必要となります。
FEEDFOLDERID           : フィードフォルダーIDを記述（必須）
INTEGERFEEDATTRIBUTEID : PlaceholderFieldがAD_CUSTOMIZER_INTEGERで登録されたフィードアトリビュートIDを記述（必須）
PRICEFEEDFOLDERID      : PlaceholderFieldがAD_CUSTOMIZER_PRICEで登録されたフィードアトリビュートIDを記述（必須）
DATEFEEDFOLDERID       : PlaceholderFieldがAD_CUSTOMIZER_DATEで登録されたフィードアトリビュートIDを記述（必須）
STRINGFEEDFOLDERID     : PlaceholderFieldがAD_CUSTOMIZER_STRINGで登録されたフィードアトリビュートIDを記述（必須）


--------------------------------
【実行】
--------------------------------
set SAMPLE_HOME={ad-api-sample}
set PACKAGE_NAME=jp.co.yahoo.ad_api_sample
set CLASS_PATH=%SAMPLE_HOME%\bin\ad-api-sample-SS-API-V5.2.jar;%SAMPLE_HOME%;%SAMPLE_HOME%\ad-api-sample\src\main\resources

■例：
---------------------------------------
java -classpath %CLASS_PATH% %PACKAGE_NAME%.accountSample.AccountSample
java -classpath %CLASS_PATH% %PACKAGE_NAME%.adCustomizerSample.AdCustomizerSample
java -classpath %CLASS_PATH% %PACKAGE_NAME%.adCustomizerSample.FeedFolderServiceSample
java -classpath %CLASS_PATH% %PACKAGE_NAME%.adCustomizerSample.FeedItemServiceSample
java -classpath %CLASS_PATH% %PACKAGE_NAME%.adDisplayOptionSample.AdDisplayOptionSample
java -classpath %CLASS_PATH% %PACKAGE_NAME%.adSample.AdSample
java -classpath %CLASS_PATH% %PACKAGE_NAME%.balanceSample.BalanceSample
java -classpath %CLASS_PATH% %PACKAGE_NAME%.bidLandscapeSample.BidLandscapeSample
java -classpath %CLASS_PATH% %PACKAGE_NAME%.bulkDownloadSample.BulkDownloadSample
java -classpath %CLASS_PATH% %PACKAGE_NAME%.bulkUploadSample.BulkUploadSample
java -classpath %CLASS_PATH% %PACKAGE_NAME%.customerSyncSample.CustomerSyncSample
java -classpath %CLASS_PATH% %PACKAGE_NAME%.conversionTrackerSample.ConversionTrackerSample
java -classpath %CLASS_PATH% %PACKAGE_NAME%.dictionarySample.DictionarySample
java -classpath %CLASS_PATH% %PACKAGE_NAME%.keywordEstimatorSample.KeywordEstimatorSample
java -classpath %CLASS_PATH% %PACKAGE_NAME%.reportDownloadSample.ReportDownloadSample
java -classpath %CLASS_PATH% %PACKAGE_NAME%.targetingIdeaSample.TargetingIdeaSample
java -classpath %CLASS_PATH% %PACKAGE_NAME%.trafficEstimatorSample.TrafficEstimatorSample
---------------------------------------

データをダウンロードする処理を実行した場合には、
downloadディレクトリにファイルが格納されます。

データをアップロードする処理を実行する場合には
実行前にあらかじめuploadディレクトリ配下にアップロードしたい
ファイルをuploadディレクトリ配下に格納しておく必要があります。
サンプルプログラムごとにファイル名は固定です。

・BulkUploadSampleの場合：SampleBulkUpload.csv
