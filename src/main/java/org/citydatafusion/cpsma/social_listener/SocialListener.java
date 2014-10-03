package org.citydatafusion.cpsma.social_listener;

import org.citydatafusion.cpsma.social_listener.configuration.PropertiesReader;
import org.citydatafusion.cpsma.social_listener.utilities.SLUtilities;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import polimi.deib.sld_online_api.OnlineAdapterController;
import polimi.deib.sld_online_api.OnlineDecoratorController;
import polimi.deib.sld_online_api.OnlineRecorderController;
import polimi.deib.sld_online_api.OnlineTranslatorController;

public class SocialListener {

	private static Logger logger = LoggerFactory.getLogger(SocialListener.class.getName());

	private static String twitterAdapterPropertiesFilePath;
	private static String cseDecPropertiesFilePath;
	private static String topicDecPropertiesFilePath;
	private static String visitorRestPropertiesFilePath;

	private static String cseRecPropertiesFilePath;

	private static String blackBoardMediatorTranslatorPropertiesFilePath;
	private static String rdfRemoteRDFTranslatorPropertiesFilePath;
	private static String rdfRemoteRDFTranslator4JenaTextPropertiesFilePath;


	private static String museoSilkDecPropertiesFilePath;
	private static String tortonaSilkDecPropertiesFilePath;
	private static String breraSilkDecPropertiesFilePath;
	private static String pRomanaSilkDecPropertiesFilePath;
	private static String pVeneziaSilkDecPropertiesFilePath;
	private static String centroSilkDecPropertiesFilePath;
	private static String universitaSilkDecPropertiesFilePath;
	private static String lambrateSilkDecPropertiesFilePath;
	private static String triennaleSilkDecPropertiesFilePath;
	private static String noZoneSilkDecPropertiesFilePath;
	
	private static String mySQLTranslatorPropertiesFilePath;

	private static String queryEngineRange;
	private static String queryEngineStep;
	private static String queryEngineDuration;

	private static String recorderType;

	private static String baseFilePath = null;

	private static String pipelineToLaunch;
	private static PropertiesReader pr;
	
	private static String replayersType;
	private static String replayersSpeed;
	private static String replayerspath;
	
	private static String sldServerAddress;

	public static void main(String[] args) throws Exception {

		if(args.length > 0){
			baseFilePath = args[0];
		} else {
			baseFilePath = "/Users/baldo/Dropbox/PropertiesFile/CPSMA_Test/basic_cpsma_configuration_file_4_eclipse.properties";
//			logger.error("Exception Occurred. Please specify the path of the configuration properties file as argument.");
//			throw new Exception();
		}

		pr = new PropertiesReader(baseFilePath);

		readParameters(pr);

		switch (pipelineToLaunch) {
		case "release":
			releasePipeline();
			break;
		case "test1":
			testPipeline();
			break;
		case "test2":
			testPipeline2();
			break;
		default:
			break;
		}
	}

	public static void testPipeline2(){

		logger.debug("Start test pipeline");

		OnlineAdapterController oac = new OnlineAdapterController(sldServerAddress);
		OnlineTranslatorController otc = new OnlineTranslatorController(sldServerAddress);
		OnlineDecoratorController odc = new OnlineDecoratorController(sldServerAddress);
//		OnlineRecorderController orc = new OnlineRecorderController(sldServerAddress);

		oac.initializeReplayer("rawTwitter", replayersType, Double.parseDouble(replayersSpeed), twitterAdapterPropertiesFilePath, replayerspath);

		odc.addDecorator("cse", "rawTwitter", cseDecPropertiesFilePath, "twitter_cse_decorated");

		odc.addDecorator("micropostgeneraltopicdecorator", "twitter_cse_decorated", topicDecPropertiesFilePath, "twitter_cse_topic_decorated");

		oac.initializeBasicQueryEngine("logical", SLUtilities.createSplitterConstructQuery("brera"), "twitter_cse_topic_decorated", queryEngineRange, queryEngineStep, queryEngineDuration, "brera"); 
		oac.initializeBasicQueryEngine("logical", SLUtilities.createSplitterConstructQuery("tortona"), "twitter_cse_topic_decorated", queryEngineRange, queryEngineStep, queryEngineStep, "tortona"); 
		oac.initializeBasicQueryEngine("logical", SLUtilities.createSplitterConstructQuery("museoscienza"), "twitter_cse_topic_decorated", queryEngineRange, queryEngineStep, queryEngineStep, "museoscienza"); 
		oac.initializeBasicQueryEngine("logical", SLUtilities.createSplitterConstructQuery("portaromana"), "twitter_cse_topic_decorated", queryEngineRange, queryEngineStep, queryEngineStep, "promana"); 
		oac.initializeBasicQueryEngine("logical", SLUtilities.createSplitterConstructQuery("portavenezia"), "twitter_cse_topic_decorated", queryEngineRange, queryEngineStep, queryEngineStep, "pvenezia"); 
		oac.initializeBasicQueryEngine("logical", SLUtilities.createSplitterConstructQuery("centro"), "twitter_cse_topic_decorated", queryEngineRange, queryEngineStep, queryEngineStep, "centro"); 
		oac.initializeBasicQueryEngine("logical", SLUtilities.createSplitterConstructQuery("universita"), "twitter_cse_topic_decorated", queryEngineRange, queryEngineStep, queryEngineStep, "universita"); 
		oac.initializeBasicQueryEngine("logical", SLUtilities.createSplitterConstructQuery("lambrate"), "twitter_cse_topic_decorated", queryEngineRange, queryEngineStep, queryEngineStep, "lambrate"); 
		oac.initializeBasicQueryEngine("logical", SLUtilities.createSplitterConstructQuery("triennale"), "twitter_cse_topic_decorated", queryEngineRange, queryEngineStep, queryEngineStep, "triennale"); 
		oac.initializeBasicQueryEngine("logical", SLUtilities.createSplitterConstructQuery("milanoMinusZone"), "twitter_cse_topic_decorated", queryEngineRange, queryEngineStep, queryEngineStep, "nozone"); 

		otc.addTranslator("console", "brera", twitterAdapterPropertiesFilePath);
		otc.addTranslator("console", "tortona", twitterAdapterPropertiesFilePath);
		otc.addTranslator("console", "museoscienza", twitterAdapterPropertiesFilePath);
		otc.addTranslator("console", "portaromana", twitterAdapterPropertiesFilePath);
		otc.addTranslator("console", "portavenezia", twitterAdapterPropertiesFilePath);
		otc.addTranslator("console", "centro", twitterAdapterPropertiesFilePath);
		otc.addTranslator("console", "universita", twitterAdapterPropertiesFilePath);
		otc.addTranslator("console", "lambrate", twitterAdapterPropertiesFilePath);
		otc.addTranslator("console", "triennale", twitterAdapterPropertiesFilePath);
		otc.addTranslator("console", "nozone", twitterAdapterPropertiesFilePath);

		
//		odc.addDecorator("silk", "brera", breraSilkDecPropertiesFilePath, "breraaftersilk");
//		odc.addDecorator("silk", "tortona", tortonaSilkDecPropertiesFilePath, "tortonaaftersilk");
//		odc.addDecorator("silk", "museoscienza", museoSilkDecPropertiesFilePath, "museoscienzaaftersilk");
//		odc.addDecorator("silk", "promana", pRomanaSilkDecPropertiesFilePath, "promanaaftersilk");
//		odc.addDecorator("silk", "pvenezia", pVeneziaSilkDecPropertiesFilePath, "pveneziaaftersilk");
//		odc.addDecorator("silk", "centro", centroSilkDecPropertiesFilePath, "centroaftersilk");
//		odc.addDecorator("silk", "universita", universitaSilkDecPropertiesFilePath, "universitaaftersilk");
//		odc.addDecorator("silk", "lambrate", lambrateSilkDecPropertiesFilePath, "lambrateaftersilk");
//		odc.addDecorator("silk", "triennale", triennaleSilkDecPropertiesFilePath, "triennaleaftersilk");
//		odc.addDecorator("silk", "nozone", noZoneSilkDecPropertiesFilePath, "noZoneaftersilk");
//
//		otc.addTranslator("visitorrest", "breraaftersilk", visitorRestPropertiesFilePath);
//		otc.addTranslator("visitorrest", "tortonaaftersilk", visitorRestPropertiesFilePath);
//		otc.addTranslator("visitorrest", "museoscienzaaftersilk", visitorRestPropertiesFilePath);
//		otc.addTranslator("visitorrest", "promanaaftersilk", visitorRestPropertiesFilePath);
//		otc.addTranslator("visitorrest", "pveneziaaftersilk", visitorRestPropertiesFilePath);
//		otc.addTranslator("visitorrest", "centroaftersilk", visitorRestPropertiesFilePath);
//		otc.addTranslator("visitorrest", "universitaaftersilk", visitorRestPropertiesFilePath);
//		otc.addTranslator("visitorrest", "lambrateaftersilk", visitorRestPropertiesFilePath);
//		otc.addTranslator("visitorrest", "triennaleaftersilk", visitorRestPropertiesFilePath);
//		otc.addTranslator("visitorrest", "noZoneaftersilk", visitorRestPropertiesFilePath);
//
//		otc.addTranslator("blackboardmediator", "breraaftersilk", blackBoardMediatorTranslatorPropertiesFilePath);
//		otc.addTranslator("blackboardmediator", "tortonaaftersilk", blackBoardMediatorTranslatorPropertiesFilePath);
//		otc.addTranslator("blackboardmediator", "museoscienzaaftersilk", blackBoardMediatorTranslatorPropertiesFilePath);
//		otc.addTranslator("blackboardmediator", "promanaaftersilk", blackBoardMediatorTranslatorPropertiesFilePath);
//		otc.addTranslator("blackboardmediator", "pveneziaaftersilk", blackBoardMediatorTranslatorPropertiesFilePath);
//		otc.addTranslator("blackboardmediator", "centroaftersilk", blackBoardMediatorTranslatorPropertiesFilePath);
//		otc.addTranslator("blackboardmediator", "universitaaftersilk", blackBoardMediatorTranslatorPropertiesFilePath);
//		otc.addTranslator("blackboardmediator", "lambrateaftersilk", blackBoardMediatorTranslatorPropertiesFilePath);
//		otc.addTranslator("blackboardmediator", "triennaleaftersilk", blackBoardMediatorTranslatorPropertiesFilePath);
//		otc.addTranslator("blackboardmediator", "noZoneaftersilk", blackBoardMediatorTranslatorPropertiesFilePath);

//		orc.addRecorder("breraaftersilk", recorderType, twitterAdapterPropertiesFilePath,"/Users/baldo/Documents/Work/cpsma_test/brera");
//		orc.addRecorder("tortonaaftersilk", recorderType, twitterAdapterPropertiesFilePath,"/Users/baldo/Documents/Work/cpsma_test/tortona");
//		orc.addRecorder("museoscienzaaftersilk", recorderType, twitterAdapterPropertiesFilePath,"/Users/baldo/Documents/Work/cpsma_test/museoscienza");
//		orc.addRecorder("promanaaftersilk", recorderType, twitterAdapterPropertiesFilePath,"/Users/baldo/Documents/Work/cpsma_test/portaRomana");
//		orc.addRecorder("pveneziaaftersilk", recorderType, twitterAdapterPropertiesFilePath,"/Users/baldo/Documents/Work/cpsma_test/portaVenezia");
//		orc.addRecorder("centroaftersilk", recorderType, twitterAdapterPropertiesFilePath,"/Users/baldo/Documents/Work/cpsma_test/centro");
//		orc.addRecorder("universitaaftersilk", recorderType, twitterAdapterPropertiesFilePath,"/Users/baldo/Documents/Work/cpsma_test/unimi");
//		orc.addRecorder("lambrateaftersilk", recorderType, twitterAdapterPropertiesFilePath,"/Users/baldo/Documents/Work/cpsma_test/lambrate");
//		orc.addRecorder("triennaleaftersilk", recorderType, twitterAdapterPropertiesFilePath,"/Users/baldo/Documents/Work/cpsma_test/triennale");
//		orc.addRecorder("noZoneaftersilk", recorderType, twitterAdapterPropertiesFilePath,"/Users/baldo/Documents/Work/cpsma_test/rest_of_milan");

//		otc.addTranslator("rdfdataset", "breraaftersilk", rdfRemoteRDFTranslator4JenaTextPropertiesFilePath);
//		otc.addTranslator("rdfdataset", "tortonaaftersilk", rdfRemoteRDFTranslator4JenaTextPropertiesFilePath);
//		otc.addTranslator("rdfdataset", "museoscienzaaftersilk", rdfRemoteRDFTranslator4JenaTextPropertiesFilePath);
//		otc.addTranslator("rdfdataset", "promanaaftersilk", rdfRemoteRDFTranslator4JenaTextPropertiesFilePath);
//		otc.addTranslator("rdfdataset", "pveneziaaftersilk", rdfRemoteRDFTranslator4JenaTextPropertiesFilePath);
//		otc.addTranslator("rdfdataset", "centroaftersilk", rdfRemoteRDFTranslator4JenaTextPropertiesFilePath);
//		otc.addTranslator("rdfdataset", "universitaaftersilk", rdfRemoteRDFTranslator4JenaTextPropertiesFilePath);
//		otc.addTranslator("rdfdataset", "lambrateaftersilk", rdfRemoteRDFTranslator4JenaTextPropertiesFilePath);
//		otc.addTranslator("rdfdataset", "triennaleaftersilk", rdfRemoteRDFTranslator4JenaTextPropertiesFilePath);
//		otc.addTranslator("rdfdataset", "noZoneaftersilk", rdfRemoteRDFTranslator4JenaTextPropertiesFilePath);

		oac.restartStreamer("rawTwitter");

	}

	public static void testPipeline(){

		OnlineAdapterController oac = new OnlineAdapterController(sldServerAddress);
		OnlineTranslatorController otc = new OnlineTranslatorController(sldServerAddress);
		OnlineDecoratorController odc = new OnlineDecoratorController(sldServerAddress);
		OnlineRecorderController orc = new OnlineRecorderController(sldServerAddress);

		oac.initializeAdapter("twitter", "rawTwitter", twitterAdapterPropertiesFilePath);

		odc.addDecorator("cse", "rawTwitter", cseDecPropertiesFilePath, "twitter_cse_decorated");
		odc.addDecorator("micropostgeneraltopicdecorator", "twitter_cse_decorated", topicDecPropertiesFilePath, "twitter_cse_topic_decorated");

		oac.initializeBasicQueryEngine("logical", SLUtilities.createSplitterConstructQuery("brera"), "twitter_cse_topic_decorated", queryEngineRange, queryEngineStep, queryEngineDuration, "brera"); 
		oac.initializeBasicQueryEngine("logical", SLUtilities.createSplitterConstructQuery("tortona"), "twitter_cse_topic_decorated", queryEngineRange, queryEngineStep, queryEngineStep, "tortona"); 
		oac.initializeBasicQueryEngine("logical", SLUtilities.createSplitterConstructQuery("museoscienza"), "twitter_cse_topic_decorated", queryEngineRange, queryEngineStep, queryEngineStep, "museoscienza"); 
		oac.initializeBasicQueryEngine("logical", SLUtilities.createSplitterConstructQuery("portaromana"), "twitter_cse_topic_decorated", queryEngineRange, queryEngineStep, queryEngineStep, "promana"); 
		oac.initializeBasicQueryEngine("logical", SLUtilities.createSplitterConstructQuery("portavenezia"), "twitter_cse_topic_decorated", queryEngineRange, queryEngineStep, queryEngineStep, "pvenezia"); 
		oac.initializeBasicQueryEngine("logical", SLUtilities.createSplitterConstructQuery("centro"), "twitter_cse_topic_decorated", queryEngineRange, queryEngineStep, queryEngineStep, "centro"); 
		oac.initializeBasicQueryEngine("logical", SLUtilities.createSplitterConstructQuery("universita"), "twitter_cse_topic_decorated", queryEngineRange, queryEngineStep, queryEngineStep, "universita"); 
		oac.initializeBasicQueryEngine("logical", SLUtilities.createSplitterConstructQuery("lambrate"), "twitter_cse_topic_decorated", queryEngineRange, queryEngineStep, queryEngineStep, "lambrate"); 
		oac.initializeBasicQueryEngine("logical", SLUtilities.createSplitterConstructQuery("triennale"), "twitter_cse_topic_decorated", queryEngineRange, queryEngineStep, queryEngineStep, "triennale"); 
		oac.initializeBasicQueryEngine("logical", SLUtilities.createSplitterConstructQuery("milanoMinusZone"), "twitter_cse_topic_decorated", queryEngineRange, queryEngineStep, queryEngineStep, "nozone"); 

		odc.addDecorator("silk", "brera", breraSilkDecPropertiesFilePath, "breraaftersilk");
		odc.addDecorator("silk", "tortona", tortonaSilkDecPropertiesFilePath, "tortonaaftersilk");
		odc.addDecorator("silk", "museoscienza", museoSilkDecPropertiesFilePath, "museoscienzaaftersilk");
		odc.addDecorator("silk", "promana", pRomanaSilkDecPropertiesFilePath, "promanaaftersilk");
		odc.addDecorator("silk", "pvenezia", pVeneziaSilkDecPropertiesFilePath, "pveneziaaftersilk");
		odc.addDecorator("silk", "centro", centroSilkDecPropertiesFilePath, "centroaftersilk");
		odc.addDecorator("silk", "universita", universitaSilkDecPropertiesFilePath, "universitaaftersilk");
		odc.addDecorator("silk", "lambrate", lambrateSilkDecPropertiesFilePath, "lambrateaftersilk");
		odc.addDecorator("silk", "triennale", triennaleSilkDecPropertiesFilePath, "triennaleaftersilk");
		odc.addDecorator("silk", "nozone", noZoneSilkDecPropertiesFilePath, "noZoneaftersilk");

		otc.addTranslator("visitorrest", "breraaftersilk", visitorRestPropertiesFilePath);
		otc.addTranslator("visitorrest", "tortonaaftersilk", visitorRestPropertiesFilePath);
		otc.addTranslator("visitorrest", "museoscienzaaftersilk", visitorRestPropertiesFilePath);
		otc.addTranslator("visitorrest", "promanaaftersilk", visitorRestPropertiesFilePath);
		otc.addTranslator("visitorrest", "pveneziaaftersilk", visitorRestPropertiesFilePath);
		otc.addTranslator("visitorrest", "centroaftersilk", visitorRestPropertiesFilePath);
		otc.addTranslator("visitorrest", "universitaaftersilk", visitorRestPropertiesFilePath);
		otc.addTranslator("visitorrest", "lambrateaftersilk", visitorRestPropertiesFilePath);
		otc.addTranslator("visitorrest", "triennaleaftersilk", visitorRestPropertiesFilePath);
		otc.addTranslator("visitorrest", "noZoneaftersilk", visitorRestPropertiesFilePath);

		otc.addTranslator("blackboardmediator", "breraaftersilk", blackBoardMediatorTranslatorPropertiesFilePath);
		otc.addTranslator("blackboardmediator", "tortonaaftersilk", blackBoardMediatorTranslatorPropertiesFilePath);
		otc.addTranslator("blackboardmediator", "museoscienzaaftersilk", blackBoardMediatorTranslatorPropertiesFilePath);
		otc.addTranslator("blackboardmediator", "promanaaftersilk", blackBoardMediatorTranslatorPropertiesFilePath);
		otc.addTranslator("blackboardmediator", "pveneziaaftersilk", blackBoardMediatorTranslatorPropertiesFilePath);
		otc.addTranslator("blackboardmediator", "centroaftersilk", blackBoardMediatorTranslatorPropertiesFilePath);
		otc.addTranslator("blackboardmediator", "universitaaftersilk", blackBoardMediatorTranslatorPropertiesFilePath);
		otc.addTranslator("blackboardmediator", "lambrateaftersilk", blackBoardMediatorTranslatorPropertiesFilePath);
		otc.addTranslator("blackboardmediator", "triennaleaftersilk", blackBoardMediatorTranslatorPropertiesFilePath);
		otc.addTranslator("blackboardmediator", "noZoneaftersilk", blackBoardMediatorTranslatorPropertiesFilePath);

		orc.addRecorder("breraaftersilk", recorderType, twitterAdapterPropertiesFilePath,"/Users/baldo/Documents/Work/cpsma_test/brera");
		orc.addRecorder("tortonaaftersilk", recorderType, twitterAdapterPropertiesFilePath,"/Users/baldo/Documents/Work/cpsma_test/tortona");
		orc.addRecorder("museoscienzaaftersilk", recorderType, twitterAdapterPropertiesFilePath,"/Users/baldo/Documents/Work/cpsma_test/museoscienza");
		orc.addRecorder("promanaaftersilk", recorderType, twitterAdapterPropertiesFilePath,"/Users/baldo/Documents/Work/cpsma_test/portaRomana");
		orc.addRecorder("pveneziaaftersilk", recorderType, twitterAdapterPropertiesFilePath,"/Users/baldo/Documents/Work/cpsma_test/portaVenezia");
		orc.addRecorder("centroaftersilk", recorderType, twitterAdapterPropertiesFilePath,"/Users/baldo/Documents/Work/cpsma_test/centro");
		orc.addRecorder("universitaaftersilk", recorderType, twitterAdapterPropertiesFilePath,"/Users/baldo/Documents/Work/cpsma_test/unimi");
		orc.addRecorder("lambrateaftersilk", recorderType, twitterAdapterPropertiesFilePath,"/Users/baldo/Documents/Work/cpsma_test/lambrate");
		orc.addRecorder("triennaleaftersilk", recorderType, twitterAdapterPropertiesFilePath,"/Users/baldo/Documents/Work/cpsma_test/triennale");
		orc.addRecorder("noZoneaftersilk", recorderType, twitterAdapterPropertiesFilePath,"/Users/baldo/Documents/Work/cpsma_test/rest_of_milan");

	}

	public static void releasePipeline() throws Exception{

		logger.debug("Start final release pipeline");

		OnlineAdapterController oac = new OnlineAdapterController(sldServerAddress);
		OnlineTranslatorController otc = new OnlineTranslatorController(sldServerAddress);
		OnlineDecoratorController odc = new OnlineDecoratorController(sldServerAddress);
		OnlineRecorderController orc = new OnlineRecorderController(sldServerAddress);

		oac.initializeAdapter("twitter", "rawTwitter", twitterAdapterPropertiesFilePath);

		odc.addDecorator("cse", "rawTwitter", cseDecPropertiesFilePath, "twitter_cse_decorated");

		orc.addRecorder("twitter_cse_decorated", "hybridtdbgraph", cseRecPropertiesFilePath);

		odc.addDecorator("micropostgeneraltopicdecorator", "twitter_cse_decorated", topicDecPropertiesFilePath, "twitter_cse_topic_decorated");

		oac.initializeBasicQueryEngine("logical", SLUtilities.createSplitterConstructQuery("brera"), "twitter_cse_topic_decorated", queryEngineRange, queryEngineStep, queryEngineDuration, "brera"); 
		oac.initializeBasicQueryEngine("logical", SLUtilities.createSplitterConstructQuery("tortona"), "twitter_cse_topic_decorated", queryEngineRange, queryEngineStep, queryEngineStep, "tortona"); 
		oac.initializeBasicQueryEngine("logical", SLUtilities.createSplitterConstructQuery("museoscienza"), "twitter_cse_topic_decorated", queryEngineRange, queryEngineStep, queryEngineStep, "museoscienza"); 
		oac.initializeBasicQueryEngine("logical", SLUtilities.createSplitterConstructQuery("portaromana"), "twitter_cse_topic_decorated", queryEngineRange, queryEngineStep, queryEngineStep, "promana"); 
		oac.initializeBasicQueryEngine("logical", SLUtilities.createSplitterConstructQuery("portavenezia"), "twitter_cse_topic_decorated", queryEngineRange, queryEngineStep, queryEngineStep, "pvenezia"); 
		oac.initializeBasicQueryEngine("logical", SLUtilities.createSplitterConstructQuery("centro"), "twitter_cse_topic_decorated", queryEngineRange, queryEngineStep, queryEngineStep, "centro"); 
		oac.initializeBasicQueryEngine("logical", SLUtilities.createSplitterConstructQuery("universita"), "twitter_cse_topic_decorated", queryEngineRange, queryEngineStep, queryEngineStep, "universita"); 
		oac.initializeBasicQueryEngine("logical", SLUtilities.createSplitterConstructQuery("lambrate"), "twitter_cse_topic_decorated", queryEngineRange, queryEngineStep, queryEngineStep, "lambrate"); 
		oac.initializeBasicQueryEngine("logical", SLUtilities.createSplitterConstructQuery("triennale"), "twitter_cse_topic_decorated", queryEngineRange, queryEngineStep, queryEngineStep, "triennale"); 
		oac.initializeBasicQueryEngine("logical", SLUtilities.createSplitterConstructQuery("milanoMinusZone"), "twitter_cse_topic_decorated", queryEngineRange, queryEngineStep, queryEngineStep, "nozone"); 

		odc.addDecorator("silk", "brera", breraSilkDecPropertiesFilePath, "breraaftersilk");
		odc.addDecorator("silk", "tortona", tortonaSilkDecPropertiesFilePath, "tortonaaftersilk");
		odc.addDecorator("silk", "museoscienza", museoSilkDecPropertiesFilePath, "museoscienzaaftersilk");
		odc.addDecorator("silk", "promana", pRomanaSilkDecPropertiesFilePath, "promanaaftersilk");
		odc.addDecorator("silk", "pvenezia", pVeneziaSilkDecPropertiesFilePath, "pveneziaaftersilk");
		odc.addDecorator("silk", "centro", centroSilkDecPropertiesFilePath, "centroaftersilk");
		odc.addDecorator("silk", "universita", universitaSilkDecPropertiesFilePath, "universitaaftersilk");
		odc.addDecorator("silk", "lambrate", lambrateSilkDecPropertiesFilePath, "lambrateaftersilk");
		odc.addDecorator("silk", "triennale", triennaleSilkDecPropertiesFilePath, "triennaleaftersilk");
		odc.addDecorator("silk", "nozone", noZoneSilkDecPropertiesFilePath, "noZoneaftersilk");

		otc.addTranslator("visitorrest", "breraaftersilk", visitorRestPropertiesFilePath);
		otc.addTranslator("visitorrest", "tortonaaftersilk", visitorRestPropertiesFilePath);
		otc.addTranslator("visitorrest", "museoscienzaaftersilk", visitorRestPropertiesFilePath);
		otc.addTranslator("visitorrest", "promanaaftersilk", visitorRestPropertiesFilePath);
		otc.addTranslator("visitorrest", "pveneziaaftersilk", visitorRestPropertiesFilePath);
		otc.addTranslator("visitorrest", "centroaftersilk", visitorRestPropertiesFilePath);
		otc.addTranslator("visitorrest", "universitaaftersilk", visitorRestPropertiesFilePath);
		otc.addTranslator("visitorrest", "lambrateaftersilk", visitorRestPropertiesFilePath);
		otc.addTranslator("visitorrest", "triennaleaftersilk", visitorRestPropertiesFilePath);
		otc.addTranslator("visitorrest", "noZoneaftersilk", visitorRestPropertiesFilePath);

		otc.addTranslator("blackboardmediator", "breraaftersilk", blackBoardMediatorTranslatorPropertiesFilePath);
		otc.addTranslator("blackboardmediator", "tortonaaftersilk", blackBoardMediatorTranslatorPropertiesFilePath);
		otc.addTranslator("blackboardmediator", "museoscienzaaftersilk", blackBoardMediatorTranslatorPropertiesFilePath);
		otc.addTranslator("blackboardmediator", "promanaaftersilk", blackBoardMediatorTranslatorPropertiesFilePath);
		otc.addTranslator("blackboardmediator", "pveneziaaftersilk", blackBoardMediatorTranslatorPropertiesFilePath);
		otc.addTranslator("blackboardmediator", "centroaftersilk", blackBoardMediatorTranslatorPropertiesFilePath);
		otc.addTranslator("blackboardmediator", "universitaaftersilk", blackBoardMediatorTranslatorPropertiesFilePath);
		otc.addTranslator("blackboardmediator", "lambrateaftersilk", blackBoardMediatorTranslatorPropertiesFilePath);
		otc.addTranslator("blackboardmediator", "triennaleaftersilk", blackBoardMediatorTranslatorPropertiesFilePath);
		otc.addTranslator("blackboardmediator", "noZoneaftersilk", blackBoardMediatorTranslatorPropertiesFilePath);
		
		otc.addTranslator("mysqlcitysensing", "breraaftersilk", mySQLTranslatorPropertiesFilePath);
		otc.addTranslator("mysqlcitysensing", "tortonaaftersilk", mySQLTranslatorPropertiesFilePath);
		otc.addTranslator("mysqlcitysensing", "museoscienzaaftersilk", mySQLTranslatorPropertiesFilePath);
		otc.addTranslator("mysqlcitysensing", "promanaaftersilk", mySQLTranslatorPropertiesFilePath);
		otc.addTranslator("mysqlcitysensing", "pveneziaaftersilk", mySQLTranslatorPropertiesFilePath);
		otc.addTranslator("mysqlcitysensing", "centroaftersilk", mySQLTranslatorPropertiesFilePath);
		otc.addTranslator("mysqlcitysensing", "universitaaftersilk", mySQLTranslatorPropertiesFilePath);
		otc.addTranslator("mysqlcitysensing", "lambrateaftersilk", mySQLTranslatorPropertiesFilePath);
		otc.addTranslator("mysqlcitysensing", "triennaleaftersilk", mySQLTranslatorPropertiesFilePath);
		otc.addTranslator("mysqlcitysensing", "noZoneaftersilk", mySQLTranslatorPropertiesFilePath);

//		otc.addTranslator("rdfdataset", "breraaftersilk", rdfRemoteRDFTranslatorPropertiesFilePath);
//		otc.addTranslator("rdfdataset", "tortonaaftersilk", rdfRemoteRDFTranslatorPropertiesFilePath);
//		otc.addTranslator("rdfdataset", "museoscienzaaftersilk", rdfRemoteRDFTranslatorPropertiesFilePath);
//		otc.addTranslator("rdfdataset", "promanaaftersilk", rdfRemoteRDFTranslatorPropertiesFilePath);
//		otc.addTranslator("rdfdataset", "pveneziaaftersilk", rdfRemoteRDFTranslatorPropertiesFilePath);
//		otc.addTranslator("rdfdataset", "centroaftersilk", rdfRemoteRDFTranslatorPropertiesFilePath);
//		otc.addTranslator("rdfdataset", "universitaaftersilk", rdfRemoteRDFTranslatorPropertiesFilePath);
//		otc.addTranslator("rdfdataset", "lambrateaftersilk", rdfRemoteRDFTranslatorPropertiesFilePath);
//		otc.addTranslator("rdfdataset", "triennaleaftersilk", rdfRemoteRDFTranslatorPropertiesFilePath);
//		otc.addTranslator("rdfdataset", "noZoneaftersilk", rdfRemoteRDFTranslatorPropertiesFilePath);
//
//		otc.addTranslator("rdfdataset", "breraaftersilk", rdfRemoteRDFTranslator4JenaTextPropertiesFilePath);
//		otc.addTranslator("rdfdataset", "tortonaaftersilk", rdfRemoteRDFTranslator4JenaTextPropertiesFilePath);
//		otc.addTranslator("rdfdataset", "museoscienzaaftersilk", rdfRemoteRDFTranslator4JenaTextPropertiesFilePath);
//		otc.addTranslator("rdfdataset", "promanaaftersilk", rdfRemoteRDFTranslator4JenaTextPropertiesFilePath);
//		otc.addTranslator("rdfdataset", "pveneziaaftersilk", rdfRemoteRDFTranslator4JenaTextPropertiesFilePath);
//		otc.addTranslator("rdfdataset", "centroaftersilk", rdfRemoteRDFTranslator4JenaTextPropertiesFilePath);
//		otc.addTranslator("rdfdataset", "universitaaftersilk", rdfRemoteRDFTranslator4JenaTextPropertiesFilePath);
//		otc.addTranslator("rdfdataset", "lambrateaftersilk", rdfRemoteRDFTranslator4JenaTextPropertiesFilePath);
//		otc.addTranslator("rdfdataset", "triennaleaftersilk", rdfRemoteRDFTranslator4JenaTextPropertiesFilePath);
//		otc.addTranslator("rdfdataset", "noZoneaftersilk", rdfRemoteRDFTranslator4JenaTextPropertiesFilePath);

	}

	public static void readParameters(PropertiesReader pr){
		
		sldServerAddress = (String) pr.readProperty("cpsma.sldserver.address");

		pipelineToLaunch = (String) pr.readProperty("cpsma.launcher.pipeline");
		
		replayersType = (String) pr.readProperty("cpsma.replayers.type");
		replayersSpeed = (String) pr.readProperty("cpsma.replayers.speed");
		replayerspath = (String) pr.readProperty("cpsma.replayers.originalDirPath");

		recorderType = (String) pr.readProperty("cpsma.recorders.type");

		queryEngineRange = (String) pr.readProperty("cpsma.query_engines.range");
		queryEngineStep = (String) pr.readProperty("cpsma.query_engines.step");
		queryEngineDuration = (String) pr.readProperty("cpsma.query_engines.duration");

		twitterAdapterPropertiesFilePath = (String) pr.readProperty("cpsma.configuration_file_paths.twitteradapter");

		cseDecPropertiesFilePath = (String) pr.readProperty("cpsma.configuration_file_paths.decorators.cse");
		topicDecPropertiesFilePath = (String) pr.readProperty("cpsma.configuration_file_paths.decorators.topic");

		visitorRestPropertiesFilePath = (String) pr.readProperty("cpsma.configuration_file_paths.translators.visitor_rest");

		cseRecPropertiesFilePath = (String) pr.readProperty("cpsma.configuration_file_paths.recorders.cse");

		noZoneSilkDecPropertiesFilePath = (String) pr.readProperty("cpsma.configuration_file_paths.decorators.silk.no_zone");

		museoSilkDecPropertiesFilePath = (String) pr.readProperty("cpsma.configuration_file_paths.decorators.silk.museo");
		tortonaSilkDecPropertiesFilePath = (String) pr.readProperty("cpsma.configuration_file_paths.decorators.silk.tortona");
		breraSilkDecPropertiesFilePath = (String) pr.readProperty("cpsma.configuration_file_paths.decorators.silk.brera");
		pRomanaSilkDecPropertiesFilePath = (String) pr.readProperty("cpsma.configuration_file_paths.decorators.silk.museo");
		pVeneziaSilkDecPropertiesFilePath = (String) pr.readProperty("cpsma.configuration_file_paths.decorators.silk.porta_venezia");
		centroSilkDecPropertiesFilePath = (String) pr.readProperty("cpsma.configuration_file_paths.decorators.silk.centro");
		universitaSilkDecPropertiesFilePath = (String) pr.readProperty("cpsma.configuration_file_paths.decorators.silk.universita");
		lambrateSilkDecPropertiesFilePath = (String) pr.readProperty("cpsma.configuration_file_paths.decorators.silk.lambrate");
		triennaleSilkDecPropertiesFilePath = (String) pr.readProperty("cpsma.configuration_file_paths.decorators.silk.triennale");
		noZoneSilkDecPropertiesFilePath = (String) pr.readProperty("cpsma.configuration_file_paths.decorators.silk.no_zone");
		rdfRemoteRDFTranslatorPropertiesFilePath = (String) pr.readProperty("cpsma.configuration_file_paths.translators.rdf_remote_ds");
		rdfRemoteRDFTranslator4JenaTextPropertiesFilePath= (String) pr.readProperty("cpsma.configuration_file_paths.translators.rdf_remote_ds.jenatext");

		blackBoardMediatorTranslatorPropertiesFilePath = (String) pr.readProperty("cpsma.configuration_file_paths.translators.blackboardmediator");
		
		mySQLTranslatorPropertiesFilePath = (String) pr.readProperty("cpsma.configuration_file_paths.translators.mysql");

	}

}
