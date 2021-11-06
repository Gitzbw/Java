package A;

public class Computer {
    private String cpu;
    private int memory;
    private int disk;

    public Computer(String cpu, int memory, int disk) {
        this.cpu = cpu;
        this.memory = memory;
        this.disk = disk;
    }

    public int getDisk() {
        return disk;
    }

    public int getMemory() {
        return memory;
    }

    public String getCpu() {
        return cpu;
    }

    public void setCpu(String cpu) {
        this.cpu = cpu;
    }

    public void setDisk(int disk) {
        this.disk = disk;
    }

    public void setMemory(int memory) {
        this.memory = memory;
    }
    public void getDetails(){
        System.out.println("cpu = "+getCpu()+"\n"+"memory = "+getMemory()+"\n"+"disk = "+getDisk());
    }
}

