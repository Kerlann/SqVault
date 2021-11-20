class Jobs extends React.Component {
    constructor(props) {
        super(props);
        const job = [
            {
                name: "Civil",
                salaire: 50,
                numberMax: 0,
                number: 0
            },
            {
                name: "Sdf",
                salaire: 0,
                numberMax: 0,
                number: 0
            },
            {
                name: "Cuisinier",
                salaire: 100,
                numberMax: 1,
                number: 0
            },
            {
                name: "Policier",
                salaire: 200,
                numberMax: 5,
                number: 0
            },
            {
                name: "Maire",
                salaire: 500,
                numberMax: 1,
                number: 0
            },
            {
                name: "Fabriquant de Weed",
                salaire: 100,
                numberMax: 5,
                number: 0
            },
            {
                name: "Fabriquant de Meth",
                salaire: 100,
                numberMax: 5,
                number: 0
            }
        ]
        this.state = { jobs: job };
    }

    render() {
        return (
            <div class="title-box">
                <div class="title">
                    <a class="title-box-text" href="#">Metiers</a>
                </div>
                <div class="box">
                    {this.state.jobs.map((job) => (
                        <div className="jobs">
                            <img id="imageID" src="Civil.png" width="90" height="90" />
                            <a class="text-job" href="#">{job.name} <br /><a class="salary-job" href="#">Salaire: {job.salaire} €</a></a>
                            <a class="text-number-info" href="#">{job.number}/{job.numberMax}</a>
                            <button class="btn-jobs">Choisir</button>
                        </div>
                    ))}
                </div>
            </div>
        )
    }
}
