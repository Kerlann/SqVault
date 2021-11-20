class Ammo extends React.Component {
    constructor(props) {
        super(props);
        const ammos = [
            {
                name: "Munition de pistolet",
                price: 50
            }
        ]
        this.state = { ammos: ammos };
    }

    render() {
        return (
            <div class="title-box">
                <div class="title">
                    <a class="title-box-text" href="#">Munitions</a>
                </div>
                <div class="box">
                    {this.state.ammos.map((ammo) => (
                        <div className="jobs">
                            <img id="imageID" src="Civil.png" width="90" height="90" />
                            <a class="text-job" href="#">{ammo.name} <br /><a class="salary-job" href="#">Prix: {ammo.price} €</a></a>
                            <button class="btn-jobs">Acheter</button>
                        </div>
                    ))}
                </div>
            </div>
        )
    }
}
