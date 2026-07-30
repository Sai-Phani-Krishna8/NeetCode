class FreqStack {
    Stack<Integer> st;
    HashMap<Integer, Integer> freq;

    public FreqStack() {
        st = new Stack<>();
        freq = new HashMap<>();
    }

    public void push(int val) {
        st.push(val);
        freq.put(val, freq.getOrDefault(val, 0) + 1);
    }

    public int pop() {
        // Find maximum frequency
        int maxFreq = 0;
        for (int f : freq.values()) {
            maxFreq = Math.max(maxFreq, f);
        }

        Stack<Integer> temp = new Stack<>();

        while (!st.isEmpty()) {
            int x = st.pop();

            // maxfreqency  = currele freq
            if (freq.get(x) == maxFreq) {
                freq.put(x, freq.get(x) - 1);

                if (freq.get(x) == 0) {
                    freq.remove(x);
                }

                while (!temp.isEmpty()) {
                    st.push(temp.pop());
                }

                return x;
            }

            temp.push(x);
        }

        return -1; //never reached
    }
}