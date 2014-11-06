/*
 * Copyright IBM Corp. 2014
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.acme.demo.status;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/status")
public class StatusRestController {

  @Autowired
  private StatusRepository repo;
  
  @RequestMapping(method=RequestMethod.GET)
  public List<Status> getAll() {
    return repo.findAll();
  }
  
  @RequestMapping(method=RequestMethod.POST)
  public Status create(@RequestBody Status status) {
    return repo.save(status);
  }
  
  @RequestMapping(method=RequestMethod.DELETE, value="{id}")
  public void delete(@PathVariable Long id) {
    repo.delete(id);
  }
  
  @RequestMapping(method=RequestMethod.PUT, value="{id}")
  public Status update(@RequestBody Status status, @PathVariable Long id) {
    Status update = repo.findOne(id);
    update.setStatus(status.getStatus());
    return repo.save(update);
  }
}

