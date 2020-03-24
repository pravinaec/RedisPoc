package com.iplanet.im.server;


import java.util.List;
import java.util.Set;
import org.springframework.web.bind.annotation.*;

import org.redisson.api.RedissonClient;

@RestController
public class RedisController {


    // Find
    @GetMapping("/flushall")
    String flushall() {
         RedissonClient client=RedisClusterUtility.getRedisClient();
         client.getKeys().flushall();
        return "Sussess";
    }
@GetMapping("/checkflush")
    String checkFlush() {
         RedissonClient client=RedisClusterUtility.getRedisClient();
         if(client.getKeys().count()==0L){
              return "DONE";
         }else{
              return "SomeProblem";
         }
    }
    
    @GetMapping("/getListener/{name}")
    public Set<String> getListener(@PathVariable("name") String name) {
         RedissonClient client=RedisClusterUtility.getRedisClient();
        return client.getSet("LISTNERS"+name);
    }
//    // Save
//    @PostMapping("/books")
//    //return 201 instead of 200
//    @ResponseStatus(HttpStatus.CREATED)
//    Book newBook(@RequestBody Book newBook) {
//        return repository.save(newBook);
//    }
//
//    // Find
//    @GetMapping("/books/{id}")
//    Book findOne(@PathVariable Long id) {
//        return repository.findById(id)
//                .orElseThrow(() -> new BookNotFoundException(id));
//    }
//
//    // Save or update
//    @PutMapping("/books/{id}")
//    Book saveOrUpdate(@RequestBody Book newBook, @PathVariable Long id) {
//
//        return repository.findById(id)
//                .map(x -> {
//                    x.setName(newBook.getName());
//                    x.setAuthor(newBook.getAuthor());
//                    x.setPrice(newBook.getPrice());
//                    return repository.save(x);
//                })
//                .orElseGet(() -> {
//                    newBook.setId(id);
//                    return repository.save(newBook);
//                });
//    }
//
//    // update author only
//    @PatchMapping("/books/{id}")
//    Book patch(@RequestBody Map<String, String> update, @PathVariable Long id) {
//
//        return repository.findById(id)
//                .map(x -> {
//
//                    String author = update.get("author");
//                    if (!StringUtils.isEmpty(author)) {
//                        x.setAuthor(author);
//
//                        // better create a custom method to update a value = :newValue where id = :id
//                        return repository.save(x);
//                    } else {
//                        throw new BookUnSupportedFieldPatchException(update.keySet());
//                    }
//
//                })
//                .orElseGet(() -> {
//                    throw new BookNotFoundException(id);
//                });
//
//    }
//
//    @DeleteMapping("/books/{id}")
//    void deleteBook(@PathVariable Long id) {
//        repository.deleteById(id);
//    }

}
