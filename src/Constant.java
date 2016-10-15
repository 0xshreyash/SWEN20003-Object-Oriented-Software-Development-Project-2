/* SWEN20003 Object Oriented Software Development 
 * RPG Game Engine
 * Author: <Shreyassh Patodia> <spatodia>
 * Student Number : 767336
 * Email: spatodia@student.unimelb.edu.au
 */

/** Class with all the constant variables */
public abstract class Constant 
{

	    /* Things that will be common to all of the game */
	   	
		/** Starting X of Passive Monsters */
		public static final float PassiveStartingX [] = {1431,1154,807,833,
				1090,676,836,653,1343,1835,1657,1054,801,560,1275,1671,2248,
				2952,3864,4554,4683,5312,5484,6371,5473,5944,6301,6388,6410,
				5314}; 
		
		/** Starting Y of Passive Monsters */
		public static final float PassiveStartingY [] = {864,1321,2315,2657,
				3200,3187,3966,4367,2731,3017,3954,5337,5921,6682,5696,5991,
				6298,6373,6695,6443,6228,6606,5946,5634,3544,3339,3414,1994,
				1584,274};
	    
		/** Starting X of Aggressive Monster */
	    public static final float AggressiveStartingX [] = {681,691,2166,2122,
	    		2284,2072,2006,2385,2446,2517,4157,4247,4137,4234,5879,5954,
	    		6016,5860,5772,5715,5653,5787,5668,5813,5236,5048,4845,4496,
	    		3457,3506,3624,2931,2715,2442,2579,2799,2768,2099, 1889,4502,
	    		5248,5345,5940,6335,6669,6598,6598,6435,6435,5076,5191,4940,
	    		4760,4883,4427,3559,3779,3573,3534,3635,3402,3151,3005,2763,
	    		2648,2621,2907,2331,2987,1979,2045,2069,1255, 2545,4189, 5720,
	    		5649, 5291, 5256, 4790,4648, 3628, 3771, 3182,3116,2803, 2850,
	    		2005,2132, 2242, 2428, 2427,2770, 2915,1970,2143,2069}; 
	   
	    /** Starting Y of Aggressive Monster */
	    public static final float AggressiveStartingY[] = {3201,4360,2650,2725,
	    		2962,4515,4568,4629,4590,4532,6730,6620,6519,6449,4994,4928,
	    		4866,4277,4277,4277,4277,797,720,454,917,1062,996,575,273,779,
	    		1192,1396,1326,1374,1159,1269,739,956,2581,6283,6581,6678,3412,
	    		3459,260,339,528,528,678,1082,1187,1175,1039,889,553,162,1553,
	    		1553,2464,2464,2861,2857,2997,2263,2263,1337,1270,598,394,394,
	    		693,1028,2924,4708,6585,622,767,312,852,976,401,1181,1181,2892,
	    		3033,2901,2426,1524,1427,1343,771,907,613,477,553,1048,510};

	    /** Item related constants */
	    /** Amulet's path */
	    public static final String AMULET_PATH = "/assets/items/amulet.png";
	    /** Elixir's path */
	    public static final String ELIXIR_PATH = "/assets/items/elixir.png";
	    /** Sword's path */
	    public static final String SWORD_PATH = "/assets/items/sword.png";
	    /** Tome's path */
	    public static final String TOME_PATH = "/assets/items/tome.png";
	    /** Amulet's name */
	    public static final String AMULET = "Amulet";
	    /** Elixir's name */
	    public static final String ELIXIR = "Elixir";
	    /** Sword's name */
	    public static final String SWORD = "Sword";
	    /** Tome's name */
	    public static final String TOME = "Tome";
	    /** Amulet's boost */
	    public static final int AMULET_BOOST = 80;
	    /** Sword's boost */
	    public static final int SWORD_BOOST = 30; 
	    /** Tome's boost */
	    public static final int TOME_BOOST = -300; 
	    /** Amulet's x positon */
	    public static final float AMULET_X = 965;
	    /** Amulet's y position */
	    public static final float AMULET_Y = 3563;
	    /** Tome's x position */
	    public static final float TOME_X = 4791;  
	    /** Tome's y position */
	    public static final float TOME_Y = 1253;
	    /** Sword's x position */
	    public static final float SWORD_X = 546;
	    /** Sword's y poistion */
	    public static final float SWORD_Y = 6707;
	    /** Elixir's x position */
	    public static final float ELIXIR_X = 1976;
	    /** Elixir's y postion */
	    public static final float ELIXIR_Y =  402;
	    /** Height of Panel */
	    public static final int PANEL_HEIGHT  = 70;
	    /** Offset of screen in y direction */
	    public static final int PANEL_Y_OFFSET  = -70;
	    /** Offset of screen in x direction */
	    public static final int PANEL_X_OFFSET = -20;
	    /** Path to panel image */ 
	    public static final String PANEL_PATH = "/assets/panel.png";
	    
	    /** Monster related constants */
	    /** Skeleton image path */
	    public static final String SKELETON_PATH = "/assets/units/skeleton.png";
	    /** Zombie image path */
	    public static final String ZOMBIE_PATH = "/assets/units/zombie.png";
	    /** Bandit image path */
        public static final String BANDIT_PATH = "/assets/units/bandit.png";
	    /** Bat image path */
	    public static final String DREADBAT_PATH = "/assets/units/dreadbat.png";
	    /** Draelic image path */
	    public static final String NECROMANCER_PATH = "/assets/units/necromancer.png";
	    /** Skeleton name */
	    public static final String SKELETON = "Skeleton";
	    /** Zombie name */
	    public static final String ZOMBIE = "Zombie";
	    /** Bandit name */
        public static final String BANDIT = "Bandit";
	    /** Bat name */
	    public static final String DREADBAT = "Dreadbat";
	    /** Darelic name */
	    public static final String NECROMANCER = "Draelic";
	    /** Number of Bats*/
	    public static final int NumberOfBats = 30; 
	    /** Number of Zombies */
	    public static final int NumberOfZombies = 38; 
	    /** Number of Bandits */
	    public static final int NumberOfBandits = 34; 
	    /** Number of Skeletons */
	    public static final int NumberOfSkeleton = 24; 
	    /** Number of Draelic */
	    public static final int NumberOfDraelic = 1;
	    /** HP of Bat */
	    public static final int BatHP = 40; 
	    /** Very small distance */
	    public static final float VERY_SMALL_DISTANCE = 0.0001f;
	    /** Positive direction */
	    public static final int posDirection = 1;
	    /** Negative direction */
	    public static final int negDirection = -1;
	    /** HP of Zombie */
	    public static final int ZombieHP = 60;
	    /** HP of Bandit */
	    public static final int BanditHP = 40; 
	    /** HP of Skeleton */
	    public static final int SkeletonHP = 100;
	    /** HP of Draelic */
	    public static final int DraelicHP = 140;
	    /** Damage by Zombie */
	    public static final int ZombieDamage = 10; 
	    /** Damage by Bandit */
	    public static final int BanditDamage = 8;
	    /** Daamage by Skeleton */
	    public static final int SkeletonDamage = 16; 
	    /** Damage by Draelic */
	    public static final int DraelicDamage = 30; 
	    /** Damage by Bat */
	    public static final int BatDamage = 0;
	    /** Cooldown for Bat */
	    public static final int BatCooldown = 0;
	    /** Cooldown for Zombie */
	    public static final int ZombieCooldown = 800;
	    /** Cooldown for Bandit */
	    public static final int BanditCooldown = 200;
	    /** Cooldown for Skeleton */
	    public static final int SkeletonCooldown = 500;
	    /** Cooldown for Draelic */
	    public static final int DraelicCooldown = 400;
	    /** Time in mSec to change direction */
	    public static final int TIME_TO_CHANGE_DIRECTION = 3000;
	    /** Time in mSec to feel safe */
	    public static final int TIME_TO_SAFETY = 5000;
	    /** Health bar width */
	    public static final float HEALTH_BAR_WIDTH = 100f;
	    		
	    /** Screen width, in pixels. */
	    public static final int screenwidth = 800;
	    
	    /** Screen height, in pixels. */
	    public static final int screenheight = 600;
	    
	    /** Game width, in pixels. */
	    public static final int gamewidth = 6912;
	    
	    /** Game height, in pixels. */
	    public static final int gameheight = 6912;
	    
	    /** Minimum coordinates on the map. */
	    /** Min x coordinate on the map. */
	    public static final int min_X = 0; 
	    
	    /** Min y coordinate on the map. */
	    public static final int min_Y = 0;
	    
	    /** Starting x-coordinate of the player */
		public static final float player_starting_X = 756; 
		
		/** Starting y-coordinate of the player. */
		public static final float player_starting_Y = 684; 
		
		/** Respawn x-coordinarte of the player */
		public static final float respawn_X = 738;
		/** Respawn y-coordinate of the player */
		public static final float respawn_Y = 549;
	    
		/** Path to assets */
	    public static final String ASSETS = "/assets/";
	   
	    /** path to the tiles */
	    public static final String TILES_IMG = "/assets/tiles.png";
	    
	    /** Villager related constants */
	    
	    /** Path to Garth */
	    public static final String PEASANT_PATH = "/assets/units/peasant.png";
	    /** Path to Aldric */
	    public static final String PRINCE_PATH = "/assets/units/prince.png";
	    /** Path to Elixier */
	    public static final String SHAMAN_PATH = "/assets/units/shaman.png"; 
	    /** Garth name */
	    public static final String PEASANT = "Garth";
	    /** Prince name */
	    public static final String PRINCE = "Prince";
	    /** Elivra name */
	    public static final String SHAMAN = "Elvira";
	    /** HP of Villager = 1*/
	    public static final int VillagerHP = 1;
	    /** VillagerCoolDown = 0*/
	    public static final int VillagerCooldown = 0;
	    /** VillagerDamage = 0 */
	    public static final int VillagerDamage = 0;
	    /** VillagerSpeed = 0 */
	    public static final int VillagerSpeed = 0;
	    
	    /** Prince starting coordinates */
	    public static final float PrinceX = 467;
	    public static final float PrinceY = 679;
	    /** Elivra starting coordinates */
	    public static final float ElviraX = 738;
	    public static final float ElivraY = 549;
	    /** Garth starting coordinates */
	    public static final float GarthX = 756;
	    public static final float GarthY = 870;
	    
	    /** Time for which the villager talks */
	    public static final int VILLAGER_SPEECH_TIME = 4000;
	    
	    /** Player related constants */
	    /** Path to player image */
	    public static final String PLAYER_PATH = "/assets/units/player.png";
	    /** Player name */
	    public static final String PLAYER = "player";
	    /** Max HP of the player */
	    public static final int PlayerHP = 100; 
	    
	    /** Max. Damage by player */
	    public static final int PlayerDamage = 26; 
	    /** Time for player to attack again */
	    public static final int PlayerCooldown = 600;
	    
	    /** Path to map.tmx from inside the assets folder. */
	    public static final String MAP = "/assets/map.tmx";
	    
	    /** Player speed */ 
	    public static final float PLAYER_SPEED = 0.25f;
	    
	    /** Aggressive Monster speed */ 
	    public static final float AG_MONSTER_SPEED = 0.25f;
	    
	    /** Passive Monster speed */ 
	    public static final float PA_MONSTER_SPEED = 0.20f;
	    
	    /** OUT_OF_BOUNDS value */
	    public static int OUT_OF_BOUNDS = -1;
	    
	    /** Follow range */
	    public static final float FOLLOW_RANGE = 150f; 
	    
	    /** Range for collision */
	    public static final float COLLIDE_RANGE = 50f;
	    
	    /** Height of Bar */
	    public static final int BAR_HEIGHT        = 20;
	    /** Bar y offset */
	    public static final int BAR_Y_OFFSET      = -70;
	    /** Bar x offset */
	    public static final int BAR_X_OFFSET      = -20;
	    
	    /** Addition to font width */
	    public static final int ADD_TO_FONT_WIDTH = 6;
	    
	    /** Pixel Chars */
	    public static final float PIXEL_CHAR = 9.5f;
	    
	    /** Dialogs by Aldric */
	    public static final String AldricSays[] = 
	    	{"Please seek out the Elixir of Life to cure the king.",
	        "The elixir! My father is cured! Thank you!"};

	    /** Dialogs by Elivra */
	    public static final String ElviraSays[] = 
	    	{"Return to me if you ever need healing.",
	        "You're looking much healthier now."};
	    
	    /** Dialogs by Garth */
	    public static final String GarthSays[] = 
	    	{"Find the Amulet of Vitality, across the river to the west.",
	        "Find the Sword of Strength - cross the bridge to the east, then head south.",
	        "Find the Tome of Agility, in the Land of Shadows.",
	        "You have found all the treasure I know of."};
	    
	    /** Max dialogs a villager can have */
	    public static final int MAX_NO_OF_DIALOGS = 4;
}
