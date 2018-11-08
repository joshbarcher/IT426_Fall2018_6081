package coordinates.launcher;

import coordinates.adapters.Point3DAdapter;
import coordinates.planes.Plane2D;
import coordinates.points.Point3D;

public class TestPoints
{
    public static void main(String[] args)
    {
        Point3D incompatibleObject = new Point3D(3, 2, 1);
        Plane2D plane = new Plane2D();

        plane.add(new Point3DAdapter(incompatibleObject));
    }
}
