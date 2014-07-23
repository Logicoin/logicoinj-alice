package com.google.logicoin.core;

import java.math.BigInteger;
import java.util.Date;
import java.util.Map;
import java.util.Vector;

/**
 * Created with IntelliJ IDEA.
 * User: Logicoin
 * Date: 8/13/13
 * Time: 7:23 PM
 * To change this template use File | Settings | File Templates.
 */
public class CoinDefinition {


    public static final String coinName = "LogiCoin";
    public static final String coinTicker = "LGC";
    public static final String coinURIScheme = "Logicoin";
    public static final String cryptsyMarketId = "26";
    public static final String cryptsyMarketCurrency = "BTC";
    public static final String PATTERN_PRIVATE_KEY_START = "6";

    public enum CoinPrecision {
        Coins,
        Millicoins,
    }
    public static final CoinPrecision coinPrecision = CoinPrecision.Coins;


    public static final String BLOCKEXPLORER_BASE_URL_PROD = "http://explorer.cryptocoinrevival.com";    //CCF
    public static final String BLOCKEXPLORER_ADDRESS_PATH = "address/";             //CCF
    public static final String BLOCKEXPLORER_TRANSACTION_PATH = "tx/";              //CCF
    public static final String BLOCKEXPLORER_BLOCK_PATH = "block/";                 //CCF
    public static final String BLOCKEXPLORER_BASE_URL_TEST = BLOCKEXPLORER_BASE_URL_PROD;

    public static final String DONATION_ADDRESS = "LWUkwsUi72H7tvhKm5FVGWGtrUqzEEcUWj";  //Logicoin donation address

    enum CoinHash {
        SHA256,
        scrypt,
        x11
    };
    public static final CoinHash coinPOWHash = CoinHash.x11;

    public static boolean checkpointFileSupport = true;

    public static final int TARGET_TIMESPAN = (int)(24 * 60 * 60);  // 6 hours per difficulty cycle, on average.
    public static final int TARGET_SPACING = (int)(60);  // 10 minutes seconds per block.
    public static final int INTERVAL = TARGET_TIMESPAN / TARGET_SPACING;  //36 blocks

    public static final int getInterval(int height, boolean testNet) {
            return INTERVAL;      //108
    }
    public static final int getIntervalCheckpoints() {
            return INTERVAL;

    }
    public static final int getTargetTimespan(int height, boolean testNet) {
            return TARGET_TIMESPAN;    //72 min
    }

    public static int spendableCoinbaseDepth = 100; //main.h: static const int COINBASE_MATURITY
    public static final BigInteger MAX_MONEY = BigInteger.valueOf(10000000).multiply(Utils.COIN);                 //main.h:  MAX_MONEY
    //public static final String MAX_MONEY_STRING = "200000000";     //main.h:  MAX_MONEY

    public static final BigInteger DEFAULT_MIN_TX_FEE = BigInteger.valueOf(100000);   // MIN_TX_FEE
    public static final BigInteger DUST_LIMIT = BigInteger.valueOf(100000); //main.h CTransaction::GetMinFee        0.01 coins

    public static final int PROTOCOL_VERSION = 70002;          //version.h PROTOCOL_VERSION
    public static final int MIN_PROTOCOL_VERSION = 70002;        //version.h MIN_PROTO_VERSION

    public static final int BLOCK_CURRENTVERSION = 1;   //CBlock::CURRENT_VERSION
    public static final int MAX_BLOCK_SIZE = 1 * 1000 * 1000;


    public static final boolean supportsBloomFiltering = true; //Requires PROTOCOL_VERSION 70000 in the client

    public static final int Port    = 9653;       //protocol.h GetDefaultPort(testnet=false)
    public static final int TestPort = 19653;     //protocol.h GetDefaultPort(testnet=true)

    //
    //  Production
    //
    public static final int AddressHeader = 48;             //base58.h CBitcoinAddress::PUBKEY_ADDRESS
    public static final int p2shHeader = 5;             //base58.h CBitcoinAddress::SCRIPT_ADDRESS
    public static final boolean allowBitcoinPrivateKey = false; //for backward compatibility with previous version of digitalcoin
    public static final int dumpedPrivateKeyHeader = 128;   //common to all coins
    public static final long PacketMagic = 0xf6c6b6d6;      //0xfb, 0xc0, 0xb6, 0xdb

    //Genesis Block Information from main.cpp: LoadBlockIndex
    static public long genesisBlockDifficultyTarget = (0x1e0ffff0L);         //main.cpp: LoadBlockIndex
    static public long genesisBlockTime = 1397090872L;                       //main.cpp: LoadBlockIndex
    static public long genesisBlockNonce = (592149);                         //main.cpp: LoadBlockIndex
    static public String genesisHash = "00000e8f761bdcfb0a8c85c83ca5635b05409b4d80d3859cce4b21c58cbe0b78"; //main.cpp: hashGenesisBlock
    static public int genesisBlockValue = 50;                                                              //main.cpp: LoadBlockIndex
    //taken from the raw data of the block explorer
    static public String genesisXInBytes = "04ffff001d0104404e6577732e636f6d2e61752031302f30342f32303134202d2044696420556c74696d6174652057617272696f722070726564696374206869732064656174683f";   //"Logicoin se convertira en una de las monedas mas segura del mercado, checa nuestros avances"
    static public String genessiXOutBytes = "040184710fa689ad5023690c80f3a49c8f13f8d45b8c857fbcbc8bc4a8e4d3eb4b10f4d4604fa08dce601aaf0f470216fe1b51850b4acf21b179c45070ac7b03a9";

    //net.cpp strDNSSeed
    static public String[] dnsSeeds = new String[] {
            "107.178.113.62",
			"23.95.10.116",
			"127.0.0.1",
    };

    public static int minBroadcastConnections = 0;   //0 for default; we need more peers.

    //
    // TestNet - Logicoin - not tested
    //
    public static final boolean supportsTestNet = false;
    public static final int testnetAddressHeader = 111;             //base58.h CBitcoinAddress::PUBKEY_ADDRESS_TEST
    public static final int testnetp2shHeader = 196;             //base58.h CBitcoinAddress::SCRIPT_ADDRESS_TEST
    public static final long testnetPacketMagic = 0xfcc1b7dc;      //0xfc, 0xc1, 0xb7, 0xdc
    public static final String testnetGenesisHash = "5e039e1ca1dbf128973bf6cff98169e40a1b194c3b91463ab74956f413b2f9c8";
    static public long testnetGenesisBlockDifficultyTarget = (0x1e0ffff0L);         //main.cpp: LoadBlockIndex
    static public long testnetGenesisBlockTime = 1397088621L;                       //main.cpp: LoadBlockIndex
    static public long testnetGenesisBlockNonce = (97207);                         //main.cpp: LoadBlockIndex





    //main.cpp GetBlockValue(height, fee)
    public static final BigInteger GetBlockReward(int height)
    {
        int COIN = 1;
        BigInteger nSubsidy = Utils.toNanoCoins(100, 0);
        if (height == 1)
            nSubsidy = Utils.toNanoCoins(420000, 0);
        return nSubsidy;
    }

    public static int subsidyDecreaseBlockCount = 4730400;     //main.cpp GetBlockValue(height, fee)

    public static BigInteger proofOfWorkLimit = Utils.decodeCompactBits(0x1e0fffffL);  //main.cpp bnProofOfWorkLimit (~uint256(0) >> 20); // digitalcoin: starting difficulty is 1 / 2^12

    static public String[] testnetDnsSeeds = new String[] {
          "not supported"
    };
    //from main.h: CAlert::CheckSignature
    public static final String SATOSHI_KEY = "040184710fa689ad5023690c80f3a49c8f13f8d45b8c857fbcbc8bc4a8e4d3eb4b10f4d4604fa08dce601aaf0f470216fe1b51850b4acf21b179c45070ac7b03a9";
    public static final String TESTNET_SATOSHI_KEY = "04302390343f91cc401d56d68b123028bf52e5fca1939df127f63c6467cdf9c8e2c14b61104cf817d0b780da337893ecc4aaff1309e536162dabbdb45200ca2b0a";

    /** The string returned by getId() for the main, production network where people trade things. */
    public static final String ID_MAINNET = "org.logicoin.production";
    /** The string returned by getId() for the testnet. */
    public static final String ID_TESTNET = "org.logicoin.test";
    /** Unit test network. */
    public static final String ID_UNITTESTNET = "com.google.logicoin.unittest";

    //checkpoints.cpp Checkpoints::mapCheckpoints
    public static void initCheckpoints(Map<Integer, Sha256Hash> checkpoints)
    {
        checkpoints.put( 0,   new Sha256Hash("00000e8f761bdcfb0a8c85c83ca5635b05409b4d80d3859cce4b21c58cbe0b78"));
        checkpoints.put( 51191,   new Sha256Hash("000000000ab4d2ff66b784df63af6d7d927839b1fcce838ad8118c35552e622d"));
		checkpoints.put( 72571,   new Sha256Hash("0000000005c4abba9a3702d3f2836c5a521388e5898f053aabad0a4df9a94a71"));

    }

    //Unit Test Information
    public static final String UNITTEST_ADDRESS = "";
    public static final String UNITTEST_ADDRESS_PRIVATE_KEY = "";

}
