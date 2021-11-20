class Entities extends React.Component {
    constructor(props) {
        super(props);
        const entites = [
            {
                name: "Money Printer",
                price: 50
            }
        ]
        this.state = { entites: entites };
    }

    render() {
        return (
            <div class="title-box">
                <div class="title">
                    <a class="title-box-text" href="#">Entities</a>
                </div>
                <div class="box">
                    {this.state.entites.map((entite) => (
                        <div className="jobs">
                            <img id="imageID" src="Civil.png" width="90" height="90" />
                            <a class="text-job" href="#">{entite.name} <br /><a class="salary-job" href="#">Prix: {entite.price} €</a></a>
                            <button class="btn-jobs">Acheter</button>
                        </div>
                    ))}
                </div>
            </div>
        )
    }
}
