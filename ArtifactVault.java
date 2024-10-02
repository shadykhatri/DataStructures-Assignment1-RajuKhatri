import java.util.Arrays;

public class ArtifactVault {
    private Artifact[] artifacts;
    private int count; // to track number of artifacts in the vault

    // Constructor to initialize the vault with a specified size
    public ArtifactVault(int size) {
        artifacts = new Artifact[size];
        count = 0;
    }

    // Method to add an artifact to the first empty slot
    public boolean addArtifact(Artifact artifact) {
        if (count >= artifacts.length) {
            System.out.println("Vault is full. Cannot add more artifacts.");
            return false;
        }
        artifacts[count++] = artifact;
        Arrays.sort(artifacts, 0, count); //array sorted by artifact age
        return true;
    }

    // Method to remove an artifact by its name
    public boolean removeArtifact(String name) {
        for (int i = 0; i < count; i++) {
            if (artifacts[i].getName().equals(name)) {
                artifacts[i] = artifacts[count - 1]; // Replace with last artifact
                artifacts[count - 1] = null; // Clear last slot
                count--;
                Arrays.sort(artifacts, 0, count); //array sorted by artifact age
                return true;
            }
        }
        System.out.println("Artifact not found.");
        return false;
    }

    // Method to find an artifact using linear search
    public Artifact linearSearch(String name) {
        for (int i = 0; i < count; i++) {
            if (artifacts[i].getName().equals(name)) {
                return artifacts[i];
            }
        }
        return null; //If not found
    }

    // Method to find an artifact using binary search (assume the array is sorted by age)
    public Artifact binarySearch(String name) {
        int left = 0;
        int right = count - 1;

        while (left <= right) {
            int middle = left + (right - left) / 2;

            // Compare the names to find the artifact
            int comparison = artifacts[middle].getName().compareTo(name);

            if (comparison == 0) {
                return artifacts[middle];
            } else if (comparison < 0) {
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }

        return null; // If not found
    }

    // Method to display all artifacts
    public void displayArtifacts() {
        for (int i = 0; i < count; i++) {
            System.out.println(artifacts[i]);
        }
    }

    // Inner class to represent an Artifact
    public static class Artifact implements Comparable<Artifact> {
        private String name;
        private int age;

        public Artifact(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }

        @Override
        public String toString() {
            return "Artifact{Name='" + name + "', Age=" + age + "}";
        }

        @Override
        public int compareTo(Artifact other) {
            return Integer.compare(this.age, other.age); // Compare artifacts by age
        }
    }

    public static void main(String[] args) {
        ArtifactVault vault = new ArtifactVault(5);

        // Adding artifacts
        vault.addArtifact(new Artifact("Sword", 1500));
        vault.addArtifact(new Artifact("Jewellery", 500));
        vault.addArtifact(new Artifact("Pots", 10000));
        vault.addArtifact(new Artifact("Knife", 20000));

        // Display artifacts
        vault.displayArtifacts();

        // Remove an artifact
        vault.removeArtifact("Pots");

        // Display artifacts after removal
        System.out.println("After removal:");
        vault.displayArtifacts();

        // Find an artifact using linear search
        Artifact artifact = vault.linearSearch("Jewellery");
        System.out.println("Linear Search result: " + artifact);

        // Find an artifact using binary search
        artifact = vault.binarySearch("Sword");
        System.out.println("Binary Search result: " + artifact);
    }
}
