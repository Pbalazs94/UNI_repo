public class PickableData {
    public PickableData(Pickable pickable, float val, valueType type){
        this.pickable = pickable;
        value = val;
         vType = type;
    }
    public Pickable pickable;

    public float value;
    enum valueType{
        passenger,
        fuel,
        load
    }
    public valueType vType;

}
