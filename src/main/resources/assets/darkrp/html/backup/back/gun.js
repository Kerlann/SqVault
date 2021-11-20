class Gun extends React.Component {
    constructor(props) {
        super(props);
        const gunList = [
            {
                name: "Ak47",
                price: 10
            }
        ]
        this.state = { gunList: gunList };
    }

    render() {
        return (
            <>
                <div class="title-box">
                    <div class="title">
                        <a class="title-box-text" href="#">Armes</a>
                    </div>
                    <div class="box">
                        {this.state.gunList.map((gun) => (
                            <div className="jobs">
                                <img id="imageID" src="Civil.png" width="90" height="90" />
                                <a class="text-job" href="#">{gun.name} <br /><a class="salary-job" href="#">Prix: {gun.price} €</a></a>
                                <button class="btn-jobs">Acheter</button>
                            </div>
                        ))}
                    </div>
                </div>
                <div class="title-box">
                    <div class="title">
                        <a class="title-box-text" href="#">Equipements</a>
                    </div>
                    <div class="box">

                    </div>
                </div>
            </>
        )
    }
}
