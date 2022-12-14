package archive.adjoint;

public interface LeftAdjoint<g,h> extends Adjoint<g,h,RightAdjoint<h,g>> { }
