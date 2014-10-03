package org.citydatafusion.cpsma.social_listener.utilities;



public class SLUtilities {

	public static String createSplitterConstructQuery(String zone){

		String cells = null;
		String queryString = null;

		switch (zone) {
		case "brera":

			cells = "5858, 5859, 5860, 5861, 5758, 5759, 5760, 5761, 5658, 5659, 5660, 5661, 5558, 5559, 5560, 5561, 5458, 5459, 5460, 5461, 5358, 5359, 5360, 5361, 5258, 5259, 5260, 5261";
			break;
			
		case "zonabrera":

			cells = "5858, 5859, 5860, 5861, 5758, 5759, 5760, 5761, 5658, 5659, 5660, 5661, 5558, 5559, 5560, 5561, 5458, 5459, 5460, 5461, 5358, 5359, 5360, 5361, 5258, 5259, 5260, 5261";
			break;

		case "tortona":

			cells = "4749, 4750, 4751, 4752, 4753, 4649, 4650, 4651, 4652, 4653, 4549, 4550, 4551, 4552, 4553, 4449, 4450, 4451, 4452, 4453";
			break;
			
		case "zonatortona":

			cells = "4749, 4750, 4751, 4752, 4753, 4649, 4650, 4651, 4652, 4653, 4549, 4550, 4551, 4552, 4553, 4449, 4450, 4451, 4452, 4453";
			break;

		case "lambrate":

			cells = "6176, 6177, 6178, 6179, 6180, 6076, 6077, 6078, 6079, 6080, 5976, 5977, 5978, 5979, 5980, 5876, 5877, 5878, 5879, 5880";
			break;
			
		case "zonalambrate":

			cells = "6176, 6177, 6178, 6179, 6180, 6076, 6077, 6078, 6079, 6080, 5976, 5977, 5978, 5979, 5980, 5876, 5877, 5878, 5879, 5880";
			break;

		case "universita":

			cells = "4961, 4962, 4963, 4964, 4861, 4862, 4863, 4864, 4761, 4762, 4763, 4764";
			break;
			
		case "universitadeglistudi":

			cells = "4961, 4962, 4963, 4964, 4861, 4862, 4863, 4864, 4761, 4762, 4763, 4764";
			break;
			
		case "unimi":

			cells = "4961, 4962, 4963, 4964, 4861, 4862, 4863, 4864, 4761, 4762, 4763, 4764";
			break;
			
		case "statale":

			cells = "4961, 4962, 4963, 4964, 4861, 4862, 4863, 4864, 4761, 4762, 4763, 4764";
			break;

		case "centro":

			cells = "5158, 5159, 5160, 5161, 5162, 5163, 5164, 5058, 5059, 5060, 5061, 5062, 5063, 5064";
			break;

		case "portavenezia":

			cells = "5862, 5863, 5864, 5865, 5866, 5867, 5868, 5869, 5870, 5762, 5763, 5764, 5765, 5766, 5767, 5768, 5769, 5770, 5662, 5663, 5664, 5665, 5666, 5667, 5668, 5669, 5670, 5562, 5563, 5564, 5565, 5566, 5567, 5568, 5569, 5570, 5462, 5463, 5464, 5465, 5466, 5467, 5468, 5469, 5470";
			break;

		case "portaromana":

			cells = "4661, 4662, 4663, 4664, 4665, 4666, 4667, 4668, 4561, 4562, 4563, 4564, 4565, 4566, 4567, 4568, 4461, 4462, 4463, 4464, 4465, 4466, 4467, 4468, 4361, 4362, 4363, 4364, 4365, 4366, 4367, 4368";
			break;

		case "museo":

			cells = "5054, 5055, 4954, 4955";
			break;
			
		case "museoscienza":

			cells = "5054, 5055, 4954, 4955";
			break;
			
		case "museodellascienza":

			cells = "5054, 5055, 4954, 4955";
			break;

		case "triennale":

			cells = "5654, 5554, 5454, 5354, 5254, 5655, 5555, 5455, 5355, 5255, 5656, 5556, 5456, 5356, 5256, 5657, 5557, 5457, 5357, 5257, 5658, 5558, 5458, 5358, 5258, 5659, 5559, 5459, 5359, 5259, 5660, 5560, 5460, 5360, 5260";
			break;
			
		case "triennaledimilano":

			cells = "5654, 5554, 5454, 5354, 5254, 5655, 5555, 5455, 5355, 5255, 5656, 5556, 5456, 5356, 5256, 5657, 5557, 5457, 5357, 5257, 5658, 5558, 5458, 5358, 5258, 5659, 5559, 5459, 5359, 5259, 5660, 5560, 5460, 5360, 5260";
			break;
			
		case "milanoMinusZone":

			cells = "5654, 5554, 5454, 5354, 5254, 5655, 5555, 5455, 5355, 5255, 5656, 5556, 5456, 5356, 5256, 5657, 5557, 5457, 5357, 5257, 5658, 5558, 5458, 5358, 5258, 5659, 5559, 5459, 5359, 5259, 5660, 5560, 5460, 5360, 5260,5054, 5055, 4954, 4955,4661, 4662, 4663, 4664, 4665, 4666, 4667, 4668, 4561, 4562, 4563, 4564, 4565, 4566, 4567, 4568, 4461, 4462, 4463, 4464, 4465, 4466, 4467, 4468, 4361, 4362, 4363, 4364, 4365, 4366, 4367, 4368,5862, 5863, 5864, 5865, 5866, 5867, 5868, 5869, 5870, 5762, 5763, 5764, 5765, 5766, 5767, 5768, 5769, 5770, 5662, 5663, 5664, 5665, 5666, 5667, 5668, 5669, 5670, 5562, 5563, 5564, 5565, 5566, 5567, 5568, 5569, 5570, 5462, 5463, 5464, 5465, 5466, 5467, 5468, 5469, 5470,5158, 5159, 5160, 5161, 5162, 5163, 5164, 5058, 5059, 5060, 5061, 5062, 5063, 5064,4961, 4962, 4963, 4964, 4861, 4862, 4863, 4864, 4761, 4762, 4763, 4764,6176, 6177, 6178, 6179, 6180, 6076, 6077, 6078, 6079, 6080, 5976, 5977, 5978, 5979, 5980, 5876, 5877, 5878, 5879, 5880,4749, 4750, 4751, 4752, 4753, 4649, 4650, 4651, 4652, 4653, 4549, 4550, 4551, 4552, 4553, 4449, 4450, 4451, 4452, 4453,5858, 5859, 5860, 5861, 5758, 5759, 5760, 5761, 5658, 5659, 5660, 5661, 5558, 5559, 5560, 5561, 5458, 5459, 5460, 5461, 5358, 5359, 5360, 5361, 5258, 5259, 5260, 5261";
			break;
			
		default:
			cells = null;
			break;

		}

		if(cells == null)		
			queryString = "PREFIX rdf:<http://www.w3.org/1999/02/22-rdf-syntax-ns#> " 
					+ "PREFIX geo:<http://www.w3.org/2003/01/geo/wgs84_pos#> "
					+ "PREFIX sioc:<http://rdfs.org/sioc/ns#> "
					+ "PREFIX sld:<http://streamreasoning.org/ontology/SLD#> "
					+ "PREFIX dcterms:<http://purl.org/dc/terms/> "
					+ "PREFIX sma:<http://www.citydatafusion.org/ontologies/2014/1/sma#> "
					+ "PREFIX cse:<http://www.citydatafusion.org/ontologies/2014/1/cse#> "
					+ "PREFIX xsd:<http://www.w3.org/2001/XMLSchema#> "
					+ "PREFIX rdfs:<http://www.w3.org/2000/01/rdf-schema#> "
					+ "CONSTRUCT {"
					+ "?micropost rdf:type ?type ; "
					+ "sma:num_retweets ?numr ; "
					+ "sma:is_retweet_of ?originalMP ; "
					+ "sma:is_in_reply_to ?inReplyEntity ; "
					+ "sioc:has_creator ?creator ; "
					+ "sioc:content ?content ; "
					+ "sioc:id ?tweetID ; "
					+ "dcterms:created ?ts ; "
					+ "sioc:topic ?tag ; "
					+ "sioc:topic ?topic ; "
					+ "sma:sentiment ?sentiment ; "
					+ "sma:contradiction_level ?contradiction ; "
					+ "sma:created_during ?ts15m ; "
					+ "sma:created_during ?ts3h ; "
					+ "sma:created_in ?cp ;"
					+ "sma:language ?language . "
					+ "?location rdf:type geo:SpatialThing ; "
					+ "geo:lat ?lat ; "
					+ "geo:long ?long . "
					+ "?creator rdf:type sioc:UserAccount ; "
					+ "sioc:id ?userID ; "
					+ "sioc:name ?name ; "
					+ "sioc:avatar ?avatar ; "
					+ "sioc:creator_of ?mpCreated . "
					+ "?cp cse:city_pixel_ID ?cpID . "
					+ "?topic sma:about ?about ; "
					+ "sma:sentiment ?topicSentiment . "
					+ "?ts15m sma:inUnixTime ?ts15minUnix . "
					+ "?ts3h sma:inUnixTime ?ts3hUnix . "
					+ "?tag rdfs:label ?taglabel ; "
					+ "rdf:type sioc:Tag . "
					+ "}"
					+ "WHERE { "
					+ "?micropost rdf:type ?type ; "
					+ "sioc:has_creator ?creator ; "
					+ "sioc:content ?content ; "
					+ "sioc:id ?tweetID ; "
					+ "dcterms:created ?ts ; "
					+ "sma:sentiment ?sentiment ; "
					+ "sma:created_during ?ts15m ; "
					+ "sma:created_during ?ts3h ; "
					+ "sma:created_in ?cp ;"
					+ "sma:language ?language ; "
					+ "geo:location ?location . "
					+ "?location geo:lat ?lat ; "
					+ "geo:long ?long . "
					+ "?creator sioc:id ?userID ; "
					+ "sioc:name ?name ; "
					+ "sioc:avatar ?avatar ; "
					+ "sioc:creator_of ?mpCreated . "
					+ "?cp cse:city_pixel_ID ?cpID . "
					+ "?ts15m sma:inUnixTime ?ts15minUnix . "
					+ "?ts3h sma:inUnixTime ?ts3hUnix . "
					+ "OPTIONAL { "
					+ "?micropost sma:contradiction_level ?contradiction . "
					+ "} "
					+ "OPTIONAL { "
					+ "?micropost sioc:topic ?tag . "
					+ "?tag rdfs:label ?taglabel"
					+ "} "
					+ "OPTIONAL { "
					+ "?micropost sioc:topic ?topic . "
					+ "?topic sma:about ?about ; "
					+ "sma:sentiment ?topicSentiment . "
					+ "} "
					+ "OPTIONAL { "
					+ "?micropost sma:num_retweets ?numr  . "
					+ "} "
					+ "OPTIONAL { "
					+ "?micropost sma:num_retweets ?numr  . "
					+ "} "
					+ "OPTIONAL { "
					+ "?micropost sma:is_retweet_of ?originalMP . "
					+ "} "
					+ "OPTIONAL { "
					+ "?micropost sma:is_in_reply_to ?inReplyEntity . "
					+ "} "
					+ "}";
		else if(zone.equals("milanoMinusZone"))
			queryString = "PREFIX rdf:<http://www.w3.org/1999/02/22-rdf-syntax-ns#> " 
					+ "PREFIX geo:<http://www.w3.org/2003/01/geo/wgs84_pos#> "
					+ "PREFIX sioc:<http://rdfs.org/sioc/ns#> "
					+ "PREFIX sld:<http://streamreasoning.org/ontology/SLD#> "
					+ "PREFIX dcterms:<http://purl.org/dc/terms/> "
					+ "PREFIX sma:<http://www.citydatafusion.org/ontologies/2014/1/sma#> "
					+ "PREFIX cse:<http://www.citydatafusion.org/ontologies/2014/1/cse#> "
					+ "PREFIX xsd:<http://www.w3.org/2001/XMLSchema#> "
					+ "PREFIX rdfs:<http://www.w3.org/2000/01/rdf-schema#> "
					+ "CONSTRUCT {"
					+ "?micropost rdf:type ?type ; "
					+ "sma:num_retweets ?numr ; "
					+ "sma:is_retweet_of ?originalMP ; "
					+ "sma:is_in_reply_to ?inReplyEntity ; "
					+ "sioc:has_creator ?creator ; "
					+ "sioc:content ?content ; "
					+ "sioc:id ?tweetID ; "
					+ "dcterms:created ?ts ; "
					+ "sioc:topic ?tag ; "
					+ "sioc:topic ?topic ; "
					+ "sma:sentiment ?sentiment ; "
					+ "sma:contradiction_level ?contradiction ; "
					+ "sma:created_during ?ts15m ; "
					+ "sma:created_during ?ts3h ; "
					+ "sma:created_in ?cp ;"
					+ "sma:language ?language . "
					+ "?location rdf:type geo:SpatialThing ; "
					+ "geo:lat ?lat ; "
					+ "geo:long ?long . "
					+ "?creator rdf:type sioc:UserAccount ; "
					+ "sioc:id ?userID ; "
					+ "sioc:name ?name ; "
					+ "sioc:avatar ?avatar ; "
					+ "sioc:creator_of ?mpCreated . "
					+ "?cp cse:city_pixel_ID ?cpID . "
					+ "?topic sma:about ?about ; "
					+ "sma:sentiment ?topicSentiment . "
					+ "?ts15m sma:inUnixTime ?ts15minUnix . "
					+ "?ts3h sma:inUnixTime ?ts3hUnix . "
					+ "?tag rdfs:label ?taglabel ; "
					+ "rdf:type sioc:Tag . "
					+ "}"
					+ "WHERE { "
					+ "?micropost rdf:type ?type ; "
					+ "sioc:has_creator ?creator ; "
					+ "sioc:content ?content ; "
					+ "sioc:id ?tweetID ; "
					+ "dcterms:created ?ts ; "
					+ "sma:sentiment ?sentiment ; "
					+ "sma:created_during ?ts15m ; "
					+ "sma:created_during ?ts3h ; "
					+ "sma:created_in ?cp ;"
					+ "sma:language ?language ; "
					+ "geo:location ?location . "
					+ "?location geo:lat ?lat ; "
					+ "geo:long ?long . "
					+ "?creator sioc:id ?userID ; "
					+ "sioc:name ?name ; "
					+ "sioc:avatar ?avatar ; "
					+ "sioc:creator_of ?mpCreated . "
					+ "?cp cse:city_pixel_ID ?cpID . "
					+ "?ts15m sma:inUnixTime ?ts15minUnix . "
					+ "?ts3h sma:inUnixTime ?ts3hUnix . "
					+ "OPTIONAL { "
					+ "?micropost sma:contradiction_level ?contradiction . "
					+ "} "
					+ "OPTIONAL { "
					+ "?micropost sioc:topic ?tag . "
					+ "?tag rdfs:label ?taglabel"
					+ "} "
					+ "OPTIONAL { "
					+ "?micropost sioc:topic ?topic . "
					+ "?topic sma:about ?about ; "
					+ "sma:sentiment ?topicSentiment . "
					+ "} "
					+ "OPTIONAL { "
					+ "?micropost sma:num_retweets ?numr  . "
					+ "} "
					+ "OPTIONAL { "
					+ "?micropost sma:is_retweet_of ?originalMP . "
					+ "} "
					+ "OPTIONAL { "
					+ "?micropost sma:is_in_reply_to ?inReplyEntity . "
					+ "} "
					+ "FILTER (?cpID NOT IN ( " + cells + " )) "
					+ "}";
		else

			queryString = "PREFIX rdf:<http://www.w3.org/1999/02/22-rdf-syntax-ns#> " 
					+ "PREFIX geo:<http://www.w3.org/2003/01/geo/wgs84_pos#> "
					+ "PREFIX sioc:<http://rdfs.org/sioc/ns#> "
					+ "PREFIX sld:<http://streamreasoning.org/ontology/SLD#> "
					+ "PREFIX dcterms:<http://purl.org/dc/terms/> "
					+ "PREFIX sma:<http://www.citydatafusion.org/ontologies/2014/1/sma#> "
					+ "PREFIX cse:<http://www.citydatafusion.org/ontologies/2014/1/cse#> "
					+ "PREFIX xsd:<http://www.w3.org/2001/XMLSchema#> "
					+ "PREFIX rdfs:<http://www.w3.org/2000/01/rdf-schema#> "
					+ "CONSTRUCT {"
					+ "?micropost rdf:type ?type ; "
					+ "sma:num_retweets ?numr ; "
					+ "sma:is_retweet_of ?originalMP ; "
					+ "sma:is_in_reply_to ?inReplyEntity ; "
					+ "sioc:has_creator ?creator ; "
					+ "sioc:content ?content ; "
					+ "sioc:id ?tweetID ; "
					+ "dcterms:created ?ts ; "
					+ "sioc:topic ?tag ; "
					+ "sioc:topic ?topic ; "
					+ "sma:sentiment ?sentiment ; "
					+ "sma:contradiction_level ?contradiction ; "
					+ "sma:created_during ?ts15m ; "
					+ "sma:created_during ?ts3h ; "
					+ "sma:created_in ?cp ;"
					+ "sma:language ?language . "
					+ "?location rdf:type geo:SpatialThing ; "
					+ "geo:lat ?lat ; "
					+ "geo:long ?long . "
					+ "?creator rdf:type sioc:UserAccount ; "
					+ "sioc:id ?userID ; "
					+ "sioc:name ?name ; "
					+ "sioc:avatar ?avatar ; "
					+ "sioc:creator_of ?mpCreated . "
					+ "?cp cse:city_pixel_ID ?cpID . "
					+ "?topic sma:about ?about ; "
					+ "sma:sentiment ?topicSentiment . "
					+ "?ts15m sma:inUnixTime ?ts15minUnix . "
					+ "?ts3h sma:inUnixTime ?ts3hUnix . "
					+ "?tag rdfs:label ?taglabel ; "
					+ "rdf:type sioc:Tag . "
					+ "}"
					+ "WHERE { "
					+ "?micropost rdf:type ?type ; "
					+ "sioc:has_creator ?creator ; "
					+ "sioc:content ?content ; "
					+ "sioc:id ?tweetID ; "
					+ "dcterms:created ?ts ; "
					+ "sma:sentiment ?sentiment ; "
					+ "sma:created_during ?ts15m ; "
					+ "sma:created_during ?ts3h ; "
					+ "sma:created_in ?cp ;"
					+ "sma:language ?language ; "
					+ "geo:location ?location . "
					+ "?location geo:lat ?lat ; "
					+ "geo:long ?long . "
					+ "?creator sioc:id ?userID ; "
					+ "sioc:name ?name ; "
					+ "sioc:avatar ?avatar ; "
					+ "sioc:creator_of ?mpCreated . "
					+ "?cp cse:city_pixel_ID ?cpID . "
					+ "?ts15m sma:inUnixTime ?ts15minUnix . "
					+ "?ts3h sma:inUnixTime ?ts3hUnix . "
					+ "OPTIONAL { "
					+ "?micropost sma:contradiction_level ?contradiction . "
					+ "} "
					+ "OPTIONAL { "
					+ "?micropost sioc:topic ?tag . "
					+ "?tag rdfs:label ?taglabel"
					+ "} "
					+ "OPTIONAL { "
					+ "?micropost sioc:topic ?topic . "
					+ "?topic sma:about ?about ; "
					+ "sma:sentiment ?topicSentiment . "
					+ "} "
					+ "OPTIONAL { "
					+ "?micropost sma:num_retweets ?numr  . "
					+ "} "
					+ "OPTIONAL { "
					+ "?micropost sma:is_retweet_of ?originalMP . "
					+ "} "
					+ "OPTIONAL { "
					+ "?micropost sma:is_in_reply_to ?inReplyEntity . "
					+ "} "
					+ "FILTER (?cpID IN ( " + cells + " )) "
					+ "}";

		return queryString;

	}



}
