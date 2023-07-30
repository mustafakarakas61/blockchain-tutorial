package com.mustafa.blockchaintutorial.model;

import com.google.gson.GsonBuilder;

import java.util.ArrayList;

public class Blockchain {
    private ArrayList<Block> chain;
    private int difficulty;

    // Constructor
    public Blockchain(int difficulty) {
        this.chain = new ArrayList<>();
        this.difficulty = difficulty;
        // Genesis block (first block) creation
        addBlock(new Block(0, System.currentTimeMillis(), "Genesis Block", "0"));
    }

    // Add a new block to the blockchain
    public void addBlock(Block newBlock) {
        newBlock.mineBlock(difficulty);
        chain.add(newBlock);
    }

    // Get the latest block in the blockchain
    public Block getLatestBlock() {
        return chain.get(chain.size() - 1);
    }


    // Check if the blockchain is valid
    public boolean isChainValid() {
        for (int i = 1; i < chain.size(); i++) {
            Block currentBlock = chain.get(i);
            Block previousBlock = chain.get(i - 1);

            // Check if the hash of the block is valid
            if (!currentBlock.hash.equals(currentBlock.calculateHash())) {
                return false;
            }

            // Check if the previous hash reference is correct
            if (!currentBlock.previousHash.equals(previousBlock.hash)) {
                return false;
            }
        }
        return true;
    }

    // Print the blockchain
    public void printChain() {
        String blockchainJson = new GsonBuilder().setPrettyPrinting().create().toJson(chain);
        System.out.println(blockchainJson);
    }
}
