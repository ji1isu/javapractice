    private String find_name_by_revenue(double revenue){
        for (m_char_rev_map entry : map.entrySet()) {
            if (entry.getValue().equals(searchValue)) { // Direct comparison of integers
                System.out.println(entry.getKey());
                return entry.getKey;
                }
            }
        }