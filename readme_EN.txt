--------------------------------
<<Version>>
--------------------------------
Version 6.0.0

[Change history]
-----------
2016/05/13:
- Add CampaignExportSample at Version 6.0.

2016/04/13:
- Correspond to Version 6.0.

2015/09/16:
- Correspond to Version 5.3.

2015/05/20:
- Correspond to Version 5.2.
- Correspond to Java 1.8.
- Changed the project environment to Maven.

2014/06/13:
- Correspond to Version 5.1.

2013/12/15:
- Correspond to Version 5.0.

2013/08/28:
- Additional API from Version 4.2: Correspond to AdGroupBidMultiplierService.
- Soap API Library is changed to JAX-WS.

2013/07/22:
- Correspond to Version 4.2. The change from Version 4.0 is as below.
-- Added AdDisplayOptionSample.java


--------------------------------
<<Overview>>
--------------------------------
This sample program uses Java to call each services in API. 
Calls the API using JAX-WS.


--------------------------------
<<Contents>>
--------------------------------
[src/main/java directory]
The following programs are stored.

* Below list are the Sample program that can be executed directly.

- jp/co/yahoo/ad_api_sample
  - accountSample/AccountSample.java                                        : Sample of Get and Mutate operation for account information via AccountService.
  - accountTrackingURLSample/AccountTrackingUrlSample.java                  : Sample of Get and Mutate operation for tracking URL of account via AccountTrackingUrlService.
  - adCustomizerSample/AdCustomizerSample.java                              : Sample of Get and Mutate operation for data auto insertion via AdGroupAdService/FeedItemService/FeedFolderService/AdGroupCriterionService/AdGroupService/CampaignService.
  - adCustomizerSample/FeedFolderServiceSample.java                         : Sample of Get and Mutate operation for feed (data auto insertion) folder via FeedFolderService.
  - adCustomizerSample/FeedItemServiceSample.java                           : Sample of Get and Mutate operation for feed item via FeedItemService.
  - adDisplayOptionSample/AdDisplayOptionSample.java                        : Sample of Get and Mutate operation of Ad Display Option via FeedItemService/CampaignFeedService/AdGroupFeedService.
  - adSample/AdGroupAdServiceSample.java                                    : Sample of Get and Mutate operation of ads via AdGroupAdService.
  - adSample/AdGroupBidMultiplierServiceSample.java                         : Sample of Get and Mutate operation of Bid Adjustment of ad group via AdGroupBidMultiplierService.
  - adSample/AdGroupCriterionServiceSample.java                             : Sample of Get and Mutate operation of criterion of ad group via AdGroupCriterionService.
  - adSample/AdGroupServiceSample.java                                      : Sample of Get and Mutate operation of ad group via AdGroupService.
  - adSample/AdSample.java                                                  : Sample of Ad submission via BiddingStrategyService/CampaignService/CampaignTargetService/CampaignCriterionService/AdGroupService/AdGroupCriterionService/AdGroupAdService/AdGroupBidMultiplierService.
  - adSample/BiddingStrategyServiceSample.java                              : Sample of Get and Mutate operation for auto bidding via BiddingStrategyService.
  - adSample/CampaignCriterionServiceSample.java                            : Sample of Get and Mutate operation of negative criterion of campaign via CampaignCriterionService.
  - adSample/CampaignServiceSample.java                                     : Sample of Get and Mutate operation for campaign via CampaignService.
  - adSample/CampaignTargetServiceSample.java                               : Sample of Get and Mutate operation for target setting via CampaignTargetService.
  - advancedURLSample/advancedURLSample.java                                : Sample of Get and Mutate operation of submission using Advanced URL system via AccountTrackingUrlService/CampaignService/AdGroupService/AdGroupCriterionService/AdGroupAdService/FeedItemService.
  - balanceSample/BalanceSample.java                                        : Sample of Get account balance via BalanceService.
  - bidLandscapeSample/BidLandscapeSample.java                              : Sample of Get bid landscape via BidLandscapeService.
  - customerSyncSample/CustomerSyncSample.java                              : Sample of Get data of the operation history of account or campaign via CustomerSyncService.
  - conversionTrackerSample/ConversionTrackerSample.java                    : Sample of Get and Mutate operation for conversion via ConversionTrackerService.
  - dictionarySample/DictionarySample.java                                  : Sample of Get the list of EditorialReason and Geo code via DictionaryService.
  - keywordEstimatorSample/KeywordEstimatorSample.java                      : Sample of Get the estimate keyword data from the existing campaign via KeywordEstimatorService.
  - reportDownloadSample/ReportDownloadSample.java                          : Sample of Get report via ReportDefinitionService/ReportService
  - siteRetargetingSample/AdGroupRetargetingListServiceSample.java          : Sample of Get and Mutate operation for ad group retargeting list via AdGroupRetargetingListService.
  - siteRetargetingSample/NegativeCampaignRetargetingListServiceSample.java : Sample of Get and Mutate operation for campaign retargeting list via NegativeCampaignRetargetingListService.
  - siteRetargetingSample/RetargetingListServiceSample.java                 : Sample of Get and Mutate operation for retargeting list via RetargetingListService.
  - siteRetargetingSample/SiteRetargetingSample.java                        : Sample of Get and Mutate operation for site retargeting function via RetargetingListService/BiddingStrategyService/CampaignService/NegativeCampaignRetargetingListService/AdGroupService/AdGroupRetargetingListService.
  - targetingIdeaSample/TargetingIdeaSample.java                            : Sample of Get the related keywords based on the specified value via TargetingIdeaService.
  - trafficEstimatorSample/TrafficEstimatorSample.java                      : Sample of Get the estimate keyword data of the selected keyword via KeywordEstimatorService.
  - campaignExportSample/CampaignExportSample.java                          : Sample of Add the export job and Download via CampaignExportService.


* The following are the class called from sample programs.

- under jp/co/yahoo/ad_api_sample
 - util/SoapUtils.java		: Sample and the common process of obtaining of request destination using LocationService.
 - under jp/yahooapis/ss/V6	: The stubs and the skelton classes generated by WSDL using JAX-WS.

[src/main/resource directory]
The following resources are stored.

- bin directory: The compiled execute file of sample program and the batch file to excecute on Windows are stored.
  - run_sample.bat                : The batch file in order to execute the sample program on Windows.
  - ad-api-sample-SS-API-V6.0.jar : The jar files that compiled sample programs. 

- conf directory: Property file is stored in order to describe the each setting used in the sample program execution.
  - api_config.properties: Config file to describe each ID.

- download directory: Stores the download data file when ReportDownloadSample,CampaignExportService is executed.

- upload directory: Currently not available.

[src/test/java directory]
The following test cases are stored.

*Test case that can execute from JUnit under src/main/java/jp/co/yahoo/ad_api_sample sample program.

- jp/co/yahoo/ad_api_sample
  - accountSample/AccountSampleTest.java                                        : Test case of Get and Mutate operation for account information via AccountService.
  - accountTrackingURLSample/AccountTrackingUrlSampleTest.java                  : Test case of Get and Mutate operation for tracking URL of account via AccountTrackingUrlService.
  - adCustomizerSample/AdCustomizerSampleTest.java                              : Test case of Get and Mutate operation for data auto insertion via AdGroupAdService/FeedItemService/FeedFolderService/AdGroupCriterionService/AdGroupService/CampaignService.
  - adCustomizerSample/FeedFolderServiceSampleTest.java                         : Test case of Get and Mutate operation for feed (data auto insertion) folder via FeedFolderService.
  - adCustomizerSample/FeedItemServiceSampleTest.java                           : Test case of Get and Mutate operation for feed item via FeedItemService.
  - adDisplayOptionSample/AdDisplayOptionSampleTest.java                        : Test case of Get and Mutate operation of Ad Display Option via FeedItemService/CampaignFeedService/AdGroupFeedService.
  - adSample/AdGroupAdServiceSampleTest.java                                    : Test case of Get and Mutate operation for ad information via AdGroupAdService.
  - adSample/AdGroupBidMultiplierServiceSampleTest.java                         : Test case of Get and Mutate operation for bid multiplier information via AdGroupBidMultiplierService.
  - adSample/AdGroupCriterionServiceSampleTest.java                             : Test case of Get and Mutate operation for criteria (such as keyword) via AdGroupCriterionService.
  - adSample/AdGroupServiceSampleTest.java                                      : Test case of Get and Mutate operation for adgroup via AdGroupService.
  - adSample/AdSampleTest.java                                                  : Test case of Ad submission via BiddingStrategyService/CampaignService/CampaignTargetService/CampaignCriterionService/AdGroupService/AdGroupCriterionService/AdGroupAdService/AdGroupBidMultiplierService.
  - adSample/BiddingStrategyServiceSampleTest.java                              : Test case of Get and Mutate operation for auto bidding via BiddingStrategyService.
  - adSample/CampaignCriterionServiceSampleTest.java                            : Test case of Get and Mutate operation for negative criteria in campaign level via CampaignCriterionService.
  - adSample/CampaignServiceSampleTest.java                                     : Test case of Get and Mutate operation for campaign via CampaignService.
  - adSample/CampaignTargetServiceSampleTest.java                               : Test case of Get and Mutate operation for target setting via CampaignTargetService.
  - advancedURLSample/advancedURLSampleTest.java                                : Test case of Get and Mutate operation for submission using Advanced URL system via AccountTrackingUrlService/CampaignService/AdGroupService/AdGroupCriterionService/AdGroupAdService/FeedItemService.
  - balanceSample/BalanceSampleTest.java                                        : Test case of Get account balance via BalanceService.
  - bidLandscapeSample/BidLandscapeSampleTest.java                              : Test case of Get bid landscape via BidLandscapeService.
  - conversionTrackerSample/ConversionTrackerSampleTest.java                    : Test case of Get and Mutate operation for conversion via ConversionTrackerService.
  - customerSyncSample/CustomerSyncSampleTest.java                              : Test case of Get data of the operation history of account or campaign via CustomerSyncService.
  - dictionarySample/DictionarySampleTest.java                                  : Test case of Get the list of EditorialReason and Geo code via DictionaryService.
  - keywordEstimatorSample/KeywordEstimatorSampleTest.java                      : Test case of Get the estimate keyword data from the existing campaign via KeywordEstimatorService.
  - reportDownloadSample/ReportDownloadSampleTest.java                          : Test case of Get report via ReportDefinitionService/ReportService.
  - siteRetargetingSample/AdGroupRetargetingListServiceSampleTest.java          : Test case of Get and Mutate operation for ad group retargeting list via AdGroupRetargetingListService.
  - siteRetargetingSample/NegativeCampaignRetargetingListServiceSampleTest.java : Test case of Get and Mutate operation for campaign retargeting list via NegativeCampaignRetargetingListService.
  - siteRetargetingSample/RetargetingListServiceSampleTest.java                 : Test case of Get and Mutate operation for retargeting list via RetargetingListService.
  - siteRetargetingSample/SiteRetargetingSampleTest.java                        : Test case of Get and Mutate operation for site retargeting function via RetargetingListService/BiddingStrategyService/CampaignService/NegativeCampaignRetargetingListService/AdGroupService/AdGroupRetargetingListService.
  - targetingIdeaSample/TargetingIdeaSampleTest.java                            : Test case of Get the related keywords based on the specified value via TargetingIdeaService.
  - trafficEstimatorSample/TrafficEstimatorSampleTest.java                      : Test case of Get the estimate keyword data of the selected keyword via KeywordEstimatorService.
  - campaignExportSample/CampaignExportSampleTest.java                          : Test case of Add the export job and Download via CampaignExportService.

[src/test/resource directory]
The following resources are stored.

- conf directory: Property file is stored in order to describe the each setting used in the sample program execution.
  - api_config.properties: Config file to describe each ID.

- download directory: Stores the download data file when ReportDownloadSampleTest is executed.

- upload directory: Currently not available.


--------------------------------
<<Preparation>>
--------------------------------
Please install followings to build operation environment for Java.

 [Java 1.8(Java SE Development Kit 8)]
 http://www.oracle.com/technetwork/java/javase/downloads/index.html

Please install followings to build Maven environment for Java.

 [Apache Maven 3.1.1]
 https://maven.apache.org/download.cgi

Input each ID below to api_config.properties under the conf directory.
LOCATION            : Comment out the unnecessary line
LICENSE             : API license (Required)
APIACCOUNTID        : API account ID (Required)
APIACCOUNTPASSWORD  : API account password (Required)
ONBEHALFOFACCOUNTID : Application account ID (Optional)
ONBEHALFOFPASSWORD  : Application account password (Optional)
ACCOUNTID           : Account ID (Required)

The following ID is required to use BidLandscapeSample.
BIDDINGSTRATEGYID	 : Bidding Strategy ID (Required)
CAMPAIGNID,APPCAMPAIGNID : Campaign ID (Required)
ADGROUPID,APPADGROUPID   : Ad group ID (Required)
ADGROUPCRITERIONIDS	 : Ad group criterion ID (Optional)
			   *Can set multiple ID by using comma.

The following ID is required to use AdCustomizerSample.
FEEDFOLDERID		 : Feed Folder ID (Required)
INTEGERFEEDATTRIBUTEID	 : Feed attribute ID from registered AD_CUSTOMIZER_INTEGER in PlaceholderField (Required)
PRICEFEEDFOLDERID	 : Feed attribute ID from registered AD_CUSTOMIZER_PRICE in PlaceholderField (Required)
DATEFEEDFOLDERID	 : Feed attribute ID from registered AD_CUSTOMIZER_DATE in PlaceholderField (Required)
STRINGFEEDFOLDERID	 : Feed attribute ID from registered AD_CUSTOMIZER_STRING in PlaceholderField (Required)

The following ID is required to use SiteRetargetingSample.
TARGETLISTID	: Target list ID (Optional/New list created if it does not exist)


--------------------------------
<<Execution>>
--------------------------------
set SAMPLE_HOME={ad-api-sample}
set PACKAGE_NAME=jp.co.yahoo.ad_api_sample
set CLASS_PATH=%SAMPLE_HOME%\bin\ad-api-sample-SS-API-V6.0.jar;%SAMPLE_HOME%;%SAMPLE_HOME%\ad-api-sample\src\main\resources

[e.g.]
---------------------------------------
java -classpath %CLASS_PATH% %PACKAGE_NAME%.accountSample.AccountSample
java -classpath %CLASS_PATH% %PACKAGE_NAME%.accountTrackingURLSample.AccountTrackingUrlSample
java -classpath %CLASS_PATH% %PACKAGE_NAME%.adCustomizerSample.AdCustomizerSample
java -classpath %CLASS_PATH% %PACKAGE_NAME%.adCustomizerSample.FeedFolderServiceSample
java -classpath %CLASS_PATH% %PACKAGE_NAME%.adCustomizerSample.FeedItemServiceSample
java -classpath %CLASS_PATH% %PACKAGE_NAME%.adDisplayOptionSample.AdDisplayOptionSample
java -classpath %CLASS_PATH% %PACKAGE_NAME%.adSample.AdGroupAdServiceSample
java -classpath %CLASS_PATH% %PACKAGE_NAME%.adSample.AdGroupBidMultiplierServiceSample
java -classpath %CLASS_PATH% %PACKAGE_NAME%.adSample.AdGroupCriterionServiceSample
java -classpath %CLASS_PATH% %PACKAGE_NAME%.adSample.AdGroupServiceSample
java -classpath %CLASS_PATH% %PACKAGE_NAME%.adSample.AdSample
java -classpath %CLASS_PATH% %PACKAGE_NAME%.adSample.BiddingStrategyServiceSample
java -classpath %CLASS_PATH% %PACKAGE_NAME%.adSample.CampaignCriterionServiceSample
java -classpath %CLASS_PATH% %PACKAGE_NAME%.adSample.CampaignServiceSample
java -classpath %CLASS_PATH% %PACKAGE_NAME%.adSample.CampaignTargetServiceSample
java -classpath %CLASS_PATH% %PACKAGE_NAME%.advancedURLSample.advancedURLSample
java -classpath %CLASS_PATH% %PACKAGE_NAME%.balanceSample.BalanceSample
java -classpath %CLASS_PATH% %PACKAGE_NAME%.bidLandscapeSample.BidLandscapeSample
java -classpath %CLASS_PATH% %PACKAGE_NAME%.conversionTrackerSample.ConversionTrackerSample
java -classpath %CLASS_PATH% %PACKAGE_NAME%.customerSyncSample.CustomerSyncSample
java -classpath %CLASS_PATH% %PACKAGE_NAME%.dictionarySample.DictionarySample
java -classpath %CLASS_PATH% %PACKAGE_NAME%.keywordEstimatorSample.KeywordEstimatorSample
java -classpath %CLASS_PATH% %PACKAGE_NAME%.reportDownloadSample.ReportDownloadSample
java -classpath %CLASS_PATH% %PACKAGE_NAME%.siteRetargetingSample.AdGroupRetargetingListServiceSample
java -classpath %CLASS_PATH% %PACKAGE_NAME%.siteRetargetingSample.NegativeCampaignRetargetingListServiceSample
java -classpath %CLASS_PATH% %PACKAGE_NAME%.siteRetargetingSample.RetargetingListServiceSample
java -classpath %CLASS_PATH% %PACKAGE_NAME%.siteRetargetingSample.SiteRetargetingSample
java -classpath %CLASS_PATH% %PACKAGE_NAME%.targetingIdeaSample.TargetingIdeaSample
java -classpath %CLASS_PATH% %PACKAGE_NAME%.trafficEstimatorSample.TrafficEstimatorSample
java -classpath %CLASS_PATH% %PACKAGE_NAME%.campaignExportSample.CampaignExportSample
---------------------------------------

When the operation for data download is executed, the file will be stored in the directory of download.
