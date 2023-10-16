import java.util.ArrayList; // Required import for ArrayList

public class DemoArrayList<T> {
        private ArrayList<T> data;
        public DemoArrayList(ArrayList<T> d) {
            this.data = d;
        }

            public boolean add(T t){
                this.data.add(t);
                return false;
            }

        public T get(int index) {
            return this.data.get(index);
        }
}

