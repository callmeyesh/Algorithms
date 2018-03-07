package com.algorithms.others;

import java.util.HashMap;
import java.util.HashSet;

public class Tracker {
  public HashMap<String, HashSet<Integer>> hostNameAndId;

  public Tracker() {
    hostNameAndId = new HashMap<>();
  }

  /**
   * 
   * @param hostname
   * @return
   */
  public String allocate(String hostname) {
    HashSet<Integer> hostIds = hostNameAndId.getOrDefault(hostname, new HashSet<Integer>());
    int newId = ServerAllocationDeallocation.nextServerNumber(hostIds);
    hostIds.add(newId);
    storeHostInfo(hostname, hostIds);
    return hostname + newId;
  }

  /**
   * 
   * @param hostname
   * @throws Exception
   */
  public void deallocate(String hostname) throws Exception {
    int splitIndex = parseHostname(hostname);
    String name = hostname.substring(0, splitIndex);
    int id = Integer.parseInt(hostname.substring(splitIndex));
    HashSet<Integer> hostIds = hostNameAndId.get(name);
    hostIds.remove(id);
    storeHostInfo(name, hostIds);

  }

  /**
   * 
   * @param name
   * @param ids
   */
  private void storeHostInfo(String name, HashSet<Integer> ids) {
    hostNameAndId.put(name, ids);
  }

  /**
   * 
   * @param hostname
   * @return
   * @throws Exception
   */
  private int parseHostname(String hostname) throws Exception {
    for (int i = 0; i < hostname.length(); i++) {
      char c = hostname.charAt(i);
      if (Character.isDigit(c))
        return i;
    }
    throw new Exception("No number found");
  }

}
