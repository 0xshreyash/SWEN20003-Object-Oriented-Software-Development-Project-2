import org.newdawn.slick.geom.Vector2f;


public class Constant 
{

	    /* Things that will be common to all of the game */
	   	
		public static final float PassiveStartingX [] = {1431,1154,807,833,
				1090,676,836,653,1343,1835,1657,1054,801,560,1275,1671,2248,
				2952,3864,4554,4683,5312,5484,6371,5473,5944,6301,6388,6410,
				5314}; 
		
		public static final float PassiveStartingY [] = {864,1321,2315,2657,
				3200,3187,3966,4367,2731,3017,3954,5337,5921,6682,5696,5991,
				6298,6373,6695,6443,6228,6606,5946,5634,3544,3339,3414,1994,
				1584,274};
	    
	    public static final float AggressiveStartingX [] = {681,691,2166,2122,
	    		2284,2072,2006,2385,2446,2517,4157,4247,4137,4234,5879,5954,
	    		6016,5860,5772,5715,5653,5787,5668,5813,5236,5048,4845,4496,
	    		3457,3506,3624,2931,2715,2442,2579,2799,2768,2099, 1889,4502,
	    		5248,5345,5940,6335,6669,6598,6598,6435,6435,5076,5191,4940,
	    		4760,4883,4427,3559,3779,3573,3534,3635,3402,3151,3005,2763,
	    		2648,2621,2907,2331,2987,1979,2045,2069,1255, 2545,4189, 5720,
	    		5649, 5291, 5256, 4790,4648, 3628, 3771, 3182,3116,2803, 2850,
	    		2005,2132, 2242, 2428, 2427,2770, 2915,1970,2143,2069}; 
	   
	    public static final float AggressiveStartingY[] = {3201,4360,2650,2725,
	    		2962,4515,4568,4629,4590,4532,6730,6620,6519,6449,4994,4928,
	    		4866,4277,4277,4277,4277,797,720,454,917,1062,996,575,273,779,
	    		1192,1396,1326,1374,1159,1269,739,956,2581,6283,6581,6678,3412,
	    		3459,260,339,528,528,678,1082,1187,1175,1039,889,553,162,1553,
	    		1553,2464,2464,2861,2857,2997,2263,2263,1337,1270,598,394,394,
	    		693,1028,2924,4708,6585,622,767,312,852,976,401,1181,1181,2892,
	    		3033,2901,2426,1524,1427,1343,771,907,613,477,553,1048,510};

	    /** Item related constants */
	    
	    public static final String AMULET_PATH = "items/amulet.png";
	    
	    public static final String ELIXIR_PATH = "items/elixir.png";
	    
	    public static final String SWORD_PATH = "items/sword.png";
	    
	    public static final String TOME_PATH = "items/tome.png";
	    
	    public static final String AMULET = "amulet";
	    
	    public static final String ELIXIR = "elixir";
	    
	    public static final String SWORD = "sword";
	    
	    public static final String TOME = "tome";
	    
	    public static final int AMULET_BOOST = 80;
	    
	    public static final int SWORD_BOOST = 30; 
	    
	    public static final int ELIXIR_BOOST = -300; 
	    
	    public static final float AMULET_X = 965;
	    
	    public static final float AMULET_Y = 3563;
	    
	    public static final float TOME_X = 4791;  
	    
	    public static final float TOME_Y = 1253;
	    
	    public static final float SWORD_X = 546;
	    
	    public static final float SWORD_Y = 6707;
	    
	    public static final float ELIXIR_X = 1976;
	    
	    public static final float ELIXIR_Y =  402;
	    
	    /** Monster related constants */
	    
	    public static final String SKELETON_PATH = "units/skeleton.png";
	    
	    public static final String ZOMBIE_PATH = "units/zombie.png";
	    
        public static final String BANDIT_PATH = "units/bandit.png";
	    
	    public static final String DREADBAT_PATH = "units/dreadbat.png";
	    
	    public static final String NECROMANCER_PATH = "units/necromancer.png";
	    
	    public static final String SKELETON = "skeleton";
	    
	    public static final String ZOMBIE = "zombie";
	    
        public static final String BANDIT = "bandit";
	    
	    public static final String DREADBAT = "dreadbat";
	  
	    public static final String NECROMANCER = "necromancer";
	    
	    public static final int NumberOfBats = 30; 
	    
	    public static final int NumberOfZombies = 38; 
	    
	    public static final int NumberOfBandits = 72; 
	    
	    public static final int 
	    
    		
				
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
	    
		public static final double starting_X = 756; 
		/** Starting y-coordinate of the player. */
		public static final double starting_Y = 684; 
	    
	    public static final String ASSETS = "/assets/";
	    /** Path to image of tiles from inside the assets folder. */
	    
	    public static final String TILES_IMG = "tiles.png"; 
	    
	   
	    
	    
	    
	    public static final String PEASANT = "units/peasant.png";
	    
	    public static final String PLAYER = "units/player.png";
	    
	    public static final String PRINCE = "units/prince.png";
	    
	    public static final String SHAMAN = "units/prince.png"; 
	    
	    
	    /** Path to map.tmx from inside the assets folder. */
	    public static final String MAP = "map.tmx";
	    
	    /** Player speed */ 
	    public static final float PLAYER_SPEED = 0.25f;
	    
	    /** Aggressive Monster speed */ 
	    public static final float AG_MONSTER_SPEED = 0.25f;
	    
	    /** Passive Monster speed */ 
	    public static final float PA_MONSTER_SPEED = 0.20f;
	    
	    
	    
	    
		

}
