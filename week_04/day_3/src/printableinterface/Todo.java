package printableinterface;

import java.util.List;

public class Todo implements Printable {
  String task;
  String priority;
  boolean isDone;

  public Todo(String toTask, String toPriority, boolean toIsDone) {
    this.task = toTask;
    this.priority = toPriority;
    this.isDone = toIsDone;
  }

  @Override
  public void printAllFields() {
    System.out.println(
        "Task: " + this.task + " | Priority: " + this.priority + " | Done: " + this.isDone);
  }
}
