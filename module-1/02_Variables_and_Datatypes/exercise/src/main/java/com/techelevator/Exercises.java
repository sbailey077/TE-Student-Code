package com.techelevator;

public class Exercises {

	public static void main(String[] args) {

        /* Exercise 1
        1. 4 birds are sitting on a branch. 1 flies away. How many birds are left on
        the branch?
        */
		// ### EXAMPLE:
		int birdsOnABranch = 4;
		int birdsThatFlyAway = 1;
		int birdsRemaining = birdsOnABranch - birdsThatFlyAway;

        /* Exercise 2
        2. There are 6 birds and 3 nests. How many more birds are there than
        nests?
        */
		// ### EXAMPLE:
		int numberOfBirds = 6;
		int numberOfNests = 3;
		int numberOfExtraBirds = numberOfBirds - numberOfNests;

        /* Exercise 3
        3. 3 raccoons are playing in the woods. 2 go home to eat dinner. How
        many raccoons are left in the woods?
        */
		int playingRaccoons = 3;
		int racoonsLeavingForDinner = 2;
		int racoonsLeftInTheWoods = playingRaccoons - racoonsLeavingForDinner;

        /* Exercise 4
        4. There are 5 flowers and 3 bees. How many less bees than flowers?
        */
		int numberOfFlowers = 5;
		int numberOfBees = 3;
		int numberOfBeesLessThanFlowers = numberOfFlowers - numberOfBees;

        /* Exercise 5
        5. 1 lonely pigeon was eating breadcrumbs. Another pigeon came to eat
        breadcrumbs, too. How many pigeons are eating breadcrumbs now?
        */
		int numberOfPigeonsEatingCrumbs = 1;
		int numberOfPigeonsJoining = 1;
		int finalNumberOfPigeonsEatingCrumbs = numberOfPigeonsJoining + numberOfPigeonsEatingCrumbs;



        /* Exercise 6
        6. 3 owls were sitting on the fence. 2 more owls joined them. How many
        owls are on the fence now?
        */
		int numberOfOwlsOnFence = 3;
		int numberOfOwlsJoining = 2;
		int finalNumberOfOwlsOnFence = numberOfOwlsOnFence + numberOfOwlsJoining;

        /* Exercise 7
        7. 2 beavers were working on their home. 1 went for a swim. How many
        beavers are still working on their home?
        */
		int numberOfWorkingBeavers = 2;
		int numberOfBeaversGoingForASwim = 1;
		int numberOfBeaversStillWorking = numberOfWorkingBeavers - numberOfBeaversGoingForASwim;

        /* Exercise 8
        8. 2 toucans are sitting on a tree limb. 1 more toucan joins them. How
        many toucans in all?
        */
		int numberOfToucansOnLimb = 2;
		int numberOfToucansJoining = 1;
		int finalNumberOfToucansOnLimb = numberOfToucansOnLimb + numberOfToucansJoining;

        /* Exercise 9
        9. There are 4 squirrels in a tree with 2 nuts. How many more squirrels
        are there than nuts?
        */
		int numberOfSquirrelsInTree = 4;
		int numberOfNuts = 2;
		int differenceBetweenSquirrelsAndNuts = numberOfSquirrelsInTree - numberOfNuts;

        /* Exercise 10
        10. Mrs. Hilt found a quarter, 1 dime, and 2 nickels. How much money did
        she find?
        */
		double valueOfQuarter = 0.25;
		double valueOfDime = 0.10;
		double valueOfNickel = 0.05;
		int numberOfQuartersFound = 1;
		int numberOfDimesFound = 1;
		int numberOfNickelsFound = 2;
		double valueOfMrsHiltsMoneyInDollars = (valueOfQuarter * numberOfQuartersFound) + (valueOfDime * numberOfDimesFound) + (valueOfNickel * numberOfNickelsFound);



        /* Exercise 11
        11. Mrs. Hilt's favorite first grade classes are baking muffins. Mrs. Brier's
        class bakes 18 muffins, Mrs. MacAdams's class bakes 20 muffins, and
        Mrs. Flannery's class bakes 17 muffins. How many muffins does first
        grade bake in all?
        */
		int numberOfMuffinsMrsBriersClassBakes = 18;
		int numberOfMuffinsMrsMacAdamsClassBakes = 20;
		int numberOfMuffinsMrsFlannerysClassBakes = 17;
		int totalNumberOfMuffinsInFirstGrade = numberOfMuffinsMrsBriersClassBakes + numberOfMuffinsMrsMacAdamsClassBakes + numberOfMuffinsMrsFlannerysClassBakes;


        /* Exercise 12
        12. Mrs. Hilt bought a yoyo for 24 cents and a whistle for 14 cents. How
        much did she spend in all for the two toys?
        */
		double costOfYoyo = 0.24;
		double costOfWhistle = 0.14;
		double totalCostOfToys = costOfWhistle + costOfYoyo;


        /* Exercise 13
        13. Mrs. Hilt made 5 Rice Krispies Treats. She used 8 large marshmallows
        and 10 mini marshmallows.How many marshmallows did she use
        altogether?
        */
		int numberOfLargeMarshmallows = 8;
		int numberOfMiniMarshmallows = 10;
		int totalNumberOfMarshmallows = numberOfLargeMarshmallows + numberOfMiniMarshmallows;


        /* Exercise 14
        14. At Mrs. Hilt's house, there was 29 inches of snow, and Brecknock
        Elementary School received 17 inches of snow. How much more snow
        did Mrs. Hilt's house have?
        */
		int amountOfSnowAtMrsHiltsHouseInInches = 29;
		int amountOfSnowAtBrecknockElementaryInInches = 17;
		int differenceOfSnowBetweenMrsHiltsHouseAndBrecknockElementaryInInches = amountOfSnowAtMrsHiltsHouseInInches - amountOfSnowAtBrecknockElementaryInInches;


        /* Exercise 15
        15. Mrs. Hilt has $10. She spends $3 on a toy truck and $2 on a pencil
        case. How much money does she have left?
        */
		double mrsHiltisStartingMoneyInDollars = 10.0;
		double costOfToyTruckInDollars = 3.0;
		double costOfPencilInDollars = 2.0;
		double moneyMrsHiltHasLeft = mrsHiltisStartingMoneyInDollars - (costOfPencilInDollars + costOfToyTruckInDollars);


        /* Exercise 16
        16. Josh had 16 marbles in his collection. He lost 7 marbles. How many
        marbles does he have now?
        */
		int initialAmountOfMarblesJoshOwned = 16;
		int amountOfMarblesJoshLost = 7;
		int currentAmountOfMarblesJoshHas = initialAmountOfMarblesJoshOwned - amountOfMarblesJoshLost;


        /* Exercise 17
        17. Megan has 19 seashells. How many more seashells does she need to
        find to have 25 seashells in her collection?
        */
		int amountOfSeashellsMeganHas = 19;
		int amountOfSeashellsMeganWants = 25;
		int amountOfSeashellsMeganNeeds = amountOfSeashellsMeganWants - amountOfSeashellsMeganHas;


        /* Exercise 18
        18. Brad has 17 balloons. 8 balloons are red and the rest are green. How
        many green balloons does Brad have?
        */
		int totalBalloonsBradHas = 17;
		int amountOfRedBalloons = 8;
		int amountOfGreenBalloons = totalBalloonsBradHas - amountOfRedBalloons;


        /* Exercise 19
        19. There are 38 books on the shelf. Marta put 10 more books on the shelf.
        How many books are on the shelf now?
        */
		int initialAmountOfBooksOnShelf = 38;
		int amountOfBooksMartaAdded = 10;
		int newAmountOfBooksOnShelf = initialAmountOfBooksOnShelf + amountOfBooksMartaAdded;

        /* Exercise 20
        20. A bee has 6 legs. How many legs do 8 bees have?
        */
		int amountOfLegsBeesHave = 6;
		int amountOfBees = 8;
		int amountOfLegsFor8Bees = amountOfLegsBeesHave * amountOfBees;


        /* Exercise 21
        21. Mrs. Hilt bought an ice cream cone for 99 cents. How much would 2 ice
        cream cones cost?
        */
		double costOfOneIceCreamConeInDollars = 0.99;
		double numberOfIceCreamCones = 2.0;
		double costOf2IceCreamConesInDollars = costOfOneIceCreamConeInDollars * numberOfIceCreamCones;


        /* Exercise 22
        22. Mrs. Hilt wants to make a border around her garden. She needs 125
        rocks to complete the border. She has 64 rocks. How many more rocks
        does she need to complete the border?
        */
		int numberOfRocksNeededForBorder = 125;
		int numberOfRocksMrsHiltHas = 64;
		int numberOfRocksNeededToCompleteBorder = numberOfRocksNeededForBorder - numberOfRocksMrsHiltHas;


        /* Exercise 23
        23. Mrs. Hilt had 38 marbles. She lost 15 of them. How many marbles does
        she have left?
        */
		int initialNumberOfMarblesMrsHiltHas = 38;
		int numberOfMarblesMrsHiltLost = 15;
		int remainingNumberOfMarblesMrsHiltHas = initialNumberOfMarblesMrsHiltHas - numberOfMarblesMrsHiltLost;


        /* Exercise 24
        24. Mrs. Hilt and her sister drove to a concert 78 miles away. They drove 32
        miles and then stopped for gas. How many miles did they have left to drive?
        */
		int totalDistanceToConcertInMiles = 78;
		int milesDrivenToGasStation = 32;
		int milesLeftToConcert = totalDistanceToConcertInMiles - milesDrivenToGasStation;


        /* Exercise 25
        25. Mrs. Hilt spent 1 hour and 30 minutes shoveling snow on Saturday
        morning and 45 minutes shoveling snow on Saturday afternoon. How
        much total time (in minutes) did she spend shoveling snow?
        */
		int minutesMrsHiltShoveledSnowOnSaturdayMorning = 90;
		int minutesMrsHiltShoveledSnowOnSundayAfternoon = 45;
		int totalMinutesMrsHiltShoveledSnow = minutesMrsHiltShoveledSnowOnSaturdayMorning + minutesMrsHiltShoveledSnowOnSundayAfternoon;


        /* Exercise 26
        26. Mrs. Hilt bought 6 hot dogs. Each hot dog cost 50 cents. How much
        money did she pay for all of the hot dogs?
        */
		double numberOfHotDogsMrsHiltBought = 6.0;
		double costOfHotDogInDollars = 0.5;
		double totalCostOfHotDogsInDollars = numberOfHotDogsMrsHiltBought * costOfHotDogInDollars;


        /* Exercise 27
        27. Mrs. Hilt has 50 cents. A pencil costs 7 cents. How many pencils can
        she buy with the money she has?
        */
		int amountOfMoneyMrsHiltHasInCents = 50;
		int costOfPencilInCents = 7;
		int numberOfPencilsMrsHiltCanBuy = amountOfMoneyMrsHiltHasInCents / costOfPencilInCents;


        /* Exercise 28
        28. Mrs. Hilt saw 33 butterflies. Some of the butterflies were red and others
        were orange. If 20 of the butterflies were orange, how many of them
        were red?
        */
		int totalButterfliesMrsHiltSaw = 33;
		int numberOfOrangeButterflies = 20;
		int numberOfRedButterflies = totalButterfliesMrsHiltSaw - numberOfOrangeButterflies;


        /* Exercise 29
        29. Kate gave the clerk $1.00. Her candy cost 54 cents. How much change
        should Kate get back?
        */
		double amountOfMoneyKatePaidInDollars = 1.00;
		double costOfCandyInDollars = 0.54;
		double amountOfChangeKateReceivesInDollars = amountOfMoneyKatePaidInDollars - costOfCandyInDollars;


        /* Exercise 30
        30. Mark has 13 trees in his backyard. If he plants 12 more, how many trees
        will he have?
        */
		int initialNumberOfTreesInMarksBackyard = 13;
		int numberOfTreesMarkPlants = 12;
		int finalNumberOfTreesInMarksBackyard = initialNumberOfTreesInMarksBackyard + numberOfTreesMarkPlants;


        /* Exercise 31
        31. Joy will see her grandma in two days. How many hours until she sees
        her?
        */
		int numberOfDaysUntilJoySeesGrandma = 2;
		int numberOfHoursInADay = 24;
		int numberOfHoursUntilJoySeesGrandma = numberOfDaysUntilJoySeesGrandma * numberOfHoursInADay;


        /* Exercise 32
        32. Kim has 4 cousins. She wants to give each one 5 pieces of gum. How
        much gum will she need?
        */
		int numberOfCousinsKimHas = 4;
		int piecesOfGumToGiveToEachCousin = 5;
		int totalPiecesOfGumNeeded = piecesOfGumToGiveToEachCousin * numberOfCousinsKimHas;


        /* Exercise 33
        33. Dan has $3.00. He bought a candy bar for $1.00. How much money is
        left?
        */
		double initialNumberOfDollarsDanHas = 3.0;
		double costOfCandyBarInDollars = 1.0;
		double dansRemainingMoney = initialNumberOfDollarsDanHas - costOfCandyBarInDollars;


        /* Exercise 34
        34. 5 boats are in the lake. Each boat has 3 people. How many people are
        on boats in the lake?
        */
		int numberOfBoatsOnLake = 5;
		int numberOfPeopleInEachBoat = 3;
		int totalPeopleInBoatsOnLake = numberOfBoatsOnLake * numberOfPeopleInEachBoat;


        /* Exercise 35
        35. Ellen had 380 legos, but she lost 57 of them. How many legos does she
        have now?
        */
		int initialLegosEllenHas = 380;
		int numberOfLegosEllenLost = 57;
		int numberOfLegosEllenHasLeft = initialLegosEllenHas - numberOfLegosEllenLost;


        /* Exercise 36
        36. Arthur baked 35 muffins. How many more muffins does Arthur have to
        bake to have 83 muffins?
        */
		int amountOfMuffinsArthurBaked = 35;
		int totalMuffinsArthurNeeds = 83;
		int remainingMuffinsArthurNeedsToBake = totalMuffinsArthurNeeds - amountOfMuffinsArthurBaked;


        /* Exercise 37
        37. Willy has 1400 crayons. Lucy has 290 crayons. How many more
        crayons does Willy have then Lucy?
        */
		int amountOfCrayonsWillyHas = 1400;
		int amountOfCrayonsLucyHas = 290;
		int howManyMoreCrayonsWillyHasThanLucy = amountOfCrayonsWillyHas - amountOfCrayonsLucyHas;


        /* Exercise 38
        38. There are 10 stickers on a page. If you have 22 pages of stickers, how
        many stickers do you have?
        */
		int numberOfStickersPerPage = 10;
		int numberOfPagesWithStickers = 22;
		int totalNumberOfStickers = numberOfStickersPerPage	* numberOfPagesWithStickers;


        /* Exercise 39
        39. There are 100 cupcakes for 8 children to share. How much will each
        person get if they share the cupcakes equally?
        */
		double totalNumberOfCupcakes = 100.0;
		double numberOfChildrenEatingCupcakes = 8.0;
		double numberOfCupcakesPerChild = totalNumberOfCupcakes / numberOfChildrenEatingCupcakes;


        /* Exercise 40
        40. She made 47 gingerbread cookies which she will distribute equally in
        tiny glass jars. If each jar is to contain six cookies, how many
        cookies will not be placed in a jar?
        */
		int numberOfGingerbreadCookiesSheMade = 47;
		int numberOfCookiesEachGlassJarCanHold = 6;
		int numberOfCookiesNotPlacedInJars = numberOfGingerbreadCookiesSheMade % numberOfCookiesEachGlassJarCanHold;

        /* Exercise 41
        41. She also prepared 59 croissants which she plans to give to her 8
        neighbors. If each neighbor received an equal number of croissants,
        how many will be left with Marian?
        */
		int totalNumberOfCroissantsPrepared = 59;
		int numberOfNeighborsReceivingCroissants = 8;
		int numberOfCroissantsLeftOver = totalNumberOfCroissantsPrepared % numberOfNeighborsReceivingCroissants;


        /* Exercise 42
        42. Marian also baked oatmeal cookies for her classmates. If she can
        place 12 cookies on a tray at a time, how many trays will she need to
        prepare 276 oatmeal cookies at a time?
        */
		int totalNumberOfOatmealCookies = 276;
		int numberOfCookiesPerTray = 12;
		int numberOfTraysNeeded = totalNumberOfOatmealCookies / numberOfCookiesPerTray;


        /* Exercise 43
        43. Marian’s friends were coming over that afternoon so she made 480
        bite-sized pretzels. If one serving is equal to 12 pretzels, how many
        servings of bite-sized pretzels was Marian able to prepare?
        */
		int totalNumberOfBiteSizedPretzels = 480;
		int oneServingOfBiteSizedPretzels = 12;
		int numberOfServingsPrepared = totalNumberOfBiteSizedPretzels / oneServingOfBiteSizedPretzels;


        /* Exercise 44
        44. Lastly, she baked 53 lemon cupcakes for the children living in the city
        orphanage. If two lemon cupcakes were left at home, how many
        boxes with 3 lemon cupcakes each were given away?
        */
		int numberOfLemonCupcakes = 53;
		int numberOfCupcakesPerBox = 3;
		int numberOfBoxesGivenAway = numberOfLemonCupcakes / numberOfCupcakesPerBox;


        /* Exercise 45
        45. Susie's mom prepared 74 carrot sticks for breakfast. If the carrots
        were served equally to 12 people, how many carrot sticks were left
        uneaten?
        */
		int numberOfCarrotSticks = 74;
		int numberOfPeopleEatingCarrots = 12;
		int numberOfCarrotSticksUneaten = numberOfCarrotSticks % numberOfPeopleEatingCarrots;


        /* Exercise 46
        46. Susie and her sister gathered all 98 of their teddy bears and placed
        them on the shelves in their bedroom. If every shelf can carry a
        maximum of 7 teddy bears, how many shelves will be filled?
        */
		int totalNumberOfTeddyBears = 98;
		int numberOfTeddyBearsPerShelf = 7;
		int numberOfShelvesFilled = totalNumberOfTeddyBears / numberOfTeddyBearsPerShelf;


        /* Exercise 47
        47. Susie’s mother collected all family pictures and wanted to place all of
        them in an album. If an album can contain 20 pictures, how many
        albums will she need if there are 480 pictures?
        */
		int numberOfFamilyPictures = 480;
		int numberOfPicturesPerAlbum = 20;
		int numberOfAlbumsNeeded = numberOfFamilyPictures / numberOfPicturesPerAlbum;

        /* Exercise 48
        48. Joe, Susie’s brother, collected all 94 trading cards scattered in his
        room and placed them in boxes. If a full box can hold a maximum of 8
        cards, how many boxes were filled and how many cards are there in
        the unfilled box?
        */
		int numberOfJoesTradingCards = 94;
		int maximumNumberOfCardsPerBox = 8;
		int numberOfFullBoxes = numberOfJoesTradingCards / maximumNumberOfCardsPerBox;
		int numberOfCardsLeftOver = numberOfJoesTradingCards % maximumNumberOfCardsPerBox;

        /* Exercise 49
        49. Susie’s father repaired the bookshelves in the reading room. If he has
        210 books to be distributed equally on the 10 shelves he repaired,
        how many books will each shelf contain?
        */
		int totalNumberOfBooks = 210;
		int numberOfReadingRoomShelves = 10;
		int numberOfBooksPerReadingRoomShelf = totalNumberOfBooks / numberOfReadingRoomShelves;


        /* Exercise 50
        50. Cristina baked 17 croissants. If she planned to serve this equally to
        her seven guests, how many will each have?
        */
		int numberOfCroissantsCristinaBaked = 17;
		double numberOfGuests = 7;
		double numberOfCroissantsPerGuest = numberOfCroissantsCristinaBaked / numberOfGuests;


	    /* Exercise 51
	    51. Bill and Jill are house painters. Bill can paint a 12 x 14 room in 2.15 hours, while Jill averages
	    1.90 hours. How long will it take the two painters working together to paint 5 12 x 14 rooms?
	    Hint: Calculate the hourly rate for each painter, combine them, and then divide the total walls in feet by the combined hourly rate of the painters.
	    */
		int areaPerWallInFeet = 12 * 14;
		int numberOfWallsPerRoom = 4;
		int totalNumberOfRooms = 5;
		int totalAreaPerRoomInFeet = areaPerWallInFeet * numberOfWallsPerRoom;
		int totalAreaNeededToPaint = totalAreaPerRoomInFeet * totalNumberOfRooms;
		double billPaintingRateInRoomPerHour = 2.15;
		double jillPaintingRateInRoomPerHour = 1.90;
		double billsHourlyPaintingRatePerRoom = totalAreaPerRoomInFeet / billPaintingRateInRoomPerHour;
		double jillsHourlyPaintingRatePerRoom = totalAreaPerRoomInFeet / jillPaintingRateInRoomPerHour;
		double combinedHourlyPaintingRatePerRoom = billsHourlyPaintingRatePerRoom + jillsHourlyPaintingRatePerRoom;
		double combinedTimeToPaintTotalArea = totalAreaNeededToPaint / combinedHourlyPaintingRatePerRoom;



	    /* Exercise 52
	    52. Create and assign variables to hold a first name, last name, and middle initial. Using concatenation,
		build an additional variable to hold the full name in the order of last name, first name, middle initial. The
		last and first names should be separated by a comma followed by a space, and the middle initial must end
		with a period. Use "Grace", "Hopper, and "B" for the first name, last name, and middle initial.
		Example: "John", "Smith, "D" —> "Smith, John D."
	    */
		String firstName = "Grace ";
		String lastName = "Hopper, ";
		String middleInitial = "B.";
		String fullName = lastName + firstName + middleInitial;


	    /* Exercise 53
	    53. The distance between New York and Chicago is 800 miles, and the train has already travelled 537 miles.
	    What percentage of the trip as a whole number has been completed?
	    */
		double totalDistanceBetweenNewYorkAndChicagoInMiles = 800;
		double distanceTrainHasAlreadyTraveledInMiles = 537;
		int percentageOfTripCompleted = (int)((distanceTrainHasAlreadyTraveledInMiles / totalDistanceBetweenNewYorkAndChicagoInMiles) * 100);

	}

}
