public class DijkstrasDto {
   private String nodeName;
   private double distance;
   private String lastNodeName;

   public double getDistance() {
      return distance;
   }

   public void setDistance(double distance) {
      this.distance = distance;
   }

   public String getNodeName() {
      return nodeName;
   }

   public void setNodeName(String nodeName) {
      this.nodeName = nodeName;
   }

   public String getLastNodeName() {
      return lastNodeName;
   }

   public void setLastNodeName(String lastNodeName) {
      this.lastNodeName = lastNodeName;
   }

   public DijkstrasDto(String nodeName, double distance, String lastNodeName) {
      this.nodeName = nodeName;
      this.distance = distance;
      this.lastNodeName = lastNodeName;
   }

   public DijkstrasDto() {
   }

   public DijkstrasDto(String nodeName) {
      this.nodeName = nodeName;
   }

   @Override
   public String toString() {
      return nodeName + "  " + distance + "\t" + lastNodeName;
   }
}
