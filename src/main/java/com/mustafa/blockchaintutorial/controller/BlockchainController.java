package com.mustafa.blockchaintutorial.controller;

import com.mustafa.blockchaintutorial.model.Block;
import com.mustafa.blockchaintutorial.model.Blockchain;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/blockchain")
public class BlockchainController {

    @GetMapping("/{id}")
    public void start(@PathVariable("id") int difficulty) {
        Blockchain blockchain = new Blockchain(difficulty);

        System.out.println("Mining block 1...");
        blockchain.addBlock(new Block(1, System.currentTimeMillis(), "Transaction 1", blockchain.getLatestBlock().hash));

        System.out.println("Mining block 2...");
        blockchain.addBlock(new Block(2, System.currentTimeMillis(), "Transaction 2", blockchain.getLatestBlock().hash));

        System.out.println("Is blockchain valid? " + blockchain.isChainValid());

        System.out.println("\nBlockchain:");
        blockchain.printChain();
    }
}
