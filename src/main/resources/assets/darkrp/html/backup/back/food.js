class Food extends React.Component {
    constructor(props) {
        super(props);
        const foods = [
            {
                name: "Banane",
                price: 10
            }
        ]
        this.state = { foods: foods };
    }

    render() {
        return (
            <div class="title-box">
                <div class="title">
                    <a class="title-box-text" href="#">Nourritures</a>
                </div>
                <div class="box">
                    {this.state.foods.map((food) => (
                        <div className="jobs">
                            <img id="imageID" src="Civil.png" width="90" height="90" />
                            <a class="text-job" href="#">{food.name} <br /><a class="salary-job" href="#">Prix: {food.price} €</a></a>
                            <button class="btn-jobs">Acheter</button>
                        </div>
                    ))}
                </div>
            </div>
        )
    }
}
