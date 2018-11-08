package coordinates.adapters;

import coordinates.points.Point2D;
import coordinates.points.Point3D;

public class Point3DAdapter extends Point2D
{
    private Point3D adaptee;

    public Point3DAdapter(Point3D adaptee)
    {
        super(0, 0);
        this.adaptee = adaptee;
    }

    public int getX()
    {
        return adaptee.getX();
    }

    public int getY()
    {
        return adaptee.getY();
    }
}
